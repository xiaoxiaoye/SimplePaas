package com.remmy.simplepaas;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Set;

/**
 * @author yejiaxin
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private static final String EXAMPLE_SUFFIX = "Example";
    private static final String MAPPER_SUFFIX = "Mapper";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME = "io.swagger.annotations.ApiModelProperty";
//    private static final String BUILDER_FULL_CLASS_NAME = "lombok.Builder";

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            if (remarks.contains("\"")) {
                remarks = remarks.replace("\"", "'");
            }
            field.addJavaDocLine("@ApiModelProperty(value = \"" + remarks + "\")");
        }
    }

//    @Override
//    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        super.addModelClassComment(topLevelClass, introspectedTable);
//        topLevelClass.addAnnotation("@Builder");
//    }

//    @Override
//    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
//        imports.add(new FullyQualifiedJavaType(BUILDER_FULL_CLASS_NAME));
//        super.addClassAnnotation(innerClass, introspectedTable, imports);
//    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);

        if (!compilationUnit.getType().getFullyQualifiedName().contains(MAPPER_SUFFIX)
                && !compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
//            compilationUnit.addImportedType(new FullyQualifiedJavaType(BUILDER_FULL_CLASS_NAME));
        }
    }
}
