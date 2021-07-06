package com.remmy.simplepaas.utils;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yejiaxin
 */
@Component
public class TemplateParser {
    private final Pattern p;

    public TemplateParser() {
        this.p = Pattern.compile("\\$\\{\\w+\\}");
    }

    /**
     * 分析模板并填充变量
     *
     * @param template
     * @param params
     * @return
     */
    public String parse(String template, Map<String, String> params) {
        StringBuffer sb = new StringBuffer();
        Matcher m = this.p.matcher(template);
        while (m.find()) {
            String param = m.group();
            Object value = params.get(param.substring(2, param.length() - 1));
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public String parse(String template, Object obj) throws Exception {
        Map<String, String> params = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object valueObj = field.get(obj);
                if (valueObj == null) {
                    continue;
                }
                String value = valueObj.getClass().isPrimitive() ? String.valueOf(valueObj) : valueObj.toString();
                params.put(field.getName(), value);
            } finally {
                field.setAccessible(false);
            }
        }
        return parse(template, params);
    }
}
