package com.wisea.cultivar.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.FtlManagerUtil;
import com.wisea.cultivar.common.constants.TIMNoticeConstants;
import com.wisea.cultivar.common.entity.TIMNoticeTpl;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * TIM通知工具类
 *
 * @author XuDL(Wisea)
 *
 *         2020年4月29日 下午6:00:59
 */
public class TIMNoticeUtil {

    /** 匹配变量的正则 */
    private static Pattern pattern = Pattern.compile("\\$\\{(.*?)}");

    /**
     * 是否为带变量的模板
     *
     * @param tpl
     *            TIM消息模板
     * @return
     */
    public static boolean isVarTpl(TIMNoticeTpl tpl) {
        String content = tpl.getContent();
        if (ConverterUtil.isNotEmpty(content) && content.contains("${")) {
            return true;
        }
        return false;
    }

    /**
     * 获取不带变量的模板内容
     *
     * @param tpl
     *            TIM消息模板
     * @return
     */
    public static String getContent(TIMNoticeTpl tpl) {
        return getContent(tpl, null);
    }

    /**
     * 获取模板内容
     * <p/>
     * 模板为FTL语法，模板中的变量必须在模型中存在，否则会抛出校验异常
     *
     * @param tpl
     *            TIM消息模板
     * @param dataModel
     *            模型(Entity|Map)
     * @return
     */
    public static String getContent(TIMNoticeTpl tpl, Object dataModel) {
        String cnt = tpl.getContent();
        if (ConverterUtil.isNotEmpty(cnt)) {
            // 如果是变量模板再进行替换
            if (isVarTpl(tpl) && ConverterUtil.isNotEmpty(dataModel)) {
                // 校验模板和模型是否一致 模板中的变量必须在模型中存在
                List<String> checkRes = check(tpl, dataModel);
                if (ConverterUtil.isNotEmpty(checkRes)) {
                    throw new VerifyException(ConstantError.ERR_005, checkRes.stream().collect(Collectors.joining(";")));
                }
                return FtlManagerUtil.createWithStr(dataModel, cnt);
            }
        }
        return cnt;
    }

    /**
     * 获取变量列表
     *
     * @param tpl
     *            TIM消息模板
     * @return
     */
    public static List<String> getVarNames(TIMNoticeTpl tpl) {
        List<String> res = Lists.newArrayList();
        if (isVarTpl(tpl)) {
            Matcher matcher = pattern.matcher(tpl.getContent());
            while (matcher.find()) {
                res.add(matcher.group(1));
            }
        }
        return res;
    }

    /**
     * 模板校验(模板为FTL语法)
     *
     * @param tpl
     *            TIM消息模板
     * @param dataModel
     *            模型(Entity|Map)
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<String> check(TIMNoticeTpl tpl, Object dataModel) {
        List<String> checkMsg = Lists.newArrayList();
        if (ConverterUtil.isNotEmpty(tpl)) {
            // 如果包含变量模板再进行校验
            List<String> varList = getVarNames(tpl);
            if (ConverterUtil.isNotEmpty(varList) && null != dataModel) {
                List<String> checkRes = Lists.newArrayList();
                StandardEvaluationContext context = new StandardEvaluationContext(dataModel);
                // 构建解析器
                ExpressionParser parser = new SpelExpressionParser();
                for (String var : varList) {
                    // 进行表达式取值校验模板中的变量必填
                    // context.setVariables((Map<String, Object>)dataModel);
                    String tempVal = var;
                    // 如果是Map格式 要添加到Variables才有效 且变量以#开头
                    if (dataModel instanceof Map) {
                        tempVal = "#" + var;
                        context.setVariables((Map<String, Object>) dataModel);
                    }
                    if (ConverterUtil.isEmpty(parser.parseExpression(tempVal).getValue(context))) {
                        checkRes.add(var);
                    }
                }
                if (ConverterUtil.isNotEmpty(checkRes)) {
                    checkMsg.add("[" + varList.stream().collect(Collectors.joining(",")) + "]不能为空");
                }
            }
        }
        return checkMsg;
    }

    public static void main(String[] args) {
        TIMNoticeTpl tpl = TIMNoticeConstants.getTpl(TIMNoticeConstants.TPL_KEY_ORD_UN_COFM);
        Map<String, Object> modelMap = Maps.newHashMap();
        modelMap.put("orderId", 12345343132l);
        System.out.println(getContent(tpl, modelMap));
        // TestAttr dataModel = new TestAttr("1");
        // StandardEvaluationContext context = new StandardEvaluationContext(dataModel);
        // ExpressionParser parser = new SpelExpressionParser();
        // System.out.println(parser.parseExpression("orderId").getValue(context));
        // System.out.println(parser.parseExpression("attr.orderId").getValue(context));
        //
        // Map<String, Object> modelMap = Maps.newHashMap();
        // modelMap.put("orderId", "1");
        // TestAttr2 attr = new TestAttr2("2");
        // modelMap.put("attr", attr);
        // context.setVariables(modelMap);
        // System.out.println(parser.parseExpression("#orderId").getValue(context));
        // System.out.println(parser.parseExpression("#attr.orderId").getValue(context));
    }
}
