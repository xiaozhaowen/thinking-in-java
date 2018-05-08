package com.xiaozhao.annotation.table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解处理器
 *
 * @author xiaozhao
 */
public class TableCreator {

    /**
     * 根据实体类中注解提供的必要信息，构建出建表语句
     * <p>
     * 1、如果没有指定表名称，则使用类名
     * 2、如果没有指定列名称，则使用字段名
     */
    public static void doCreate() {
        try {
            Class<?> clazz = Class.forName("com.xiaozhao.annotation.table.Member");
            DBTable dbTable = clazz.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("在类上面没有发现DBTable的注解");
                return;
            }
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = clazz.getName().toLowerCase();
            }
            List<String> columnDefs = new ArrayList<String>();
            for (Field field : clazz.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length < 1) {
                    continue;
                }
                Annotation firstAnn = annotations[0];
                if (firstAnn instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) firstAnn;
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toLowerCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT " + getConstraints(sInt.constraints()));
                }

                if (firstAnn instanceof SQLString) {
                    SQLString sqlString = (SQLString) firstAnn;
                    if (sqlString.name().length() < 1) {
                        columnName = field.getName().toLowerCase();
                    } else {
                        columnName = sqlString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ") " + getConstraints(sqlString.constraints()));
                }
            }
            StringBuilder stringBuilder = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String def : columnDefs) {
                stringBuilder.append("\n     " + def + ",");
            }
            String result = stringBuilder.substring(0, stringBuilder.length() - 1) + ");";
            System.out.println(result);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据约束，返回数据库中建表对应的字符串
     *
     * @param constraints
     * @return
     */
    private static String getConstraints(Constraints constraints) {
        String result = "";
        if (!constraints.allowNull()) {
            result += " NOT NULL";
        }
        if (constraints.primaryKey()) {
            result += " PRIMARY KEY";
        }
        if (constraints.unique()) {
            result += " UNIQUE";
        }
        return result;
    }

    public static void main(String[] args) {
        doCreate();
    }

}
