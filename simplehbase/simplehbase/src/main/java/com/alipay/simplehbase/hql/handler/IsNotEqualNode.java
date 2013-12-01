package com.alipay.simplehbase.hql.handler;

import java.util.Map;

import com.alipay.simplehbase.hql.HQLNodeType;
import com.alipay.simplehbase.literal.LiteralValue;

public class IsNotEqualNode extends BinaryNode {

    protected IsNotEqualNode() {
        super(HQLNodeType.IsNotEqual);
    }

    @Override
    protected boolean isConditionSatisfied(Map<String, Object> para) {
        Object propertyObject = para.get(getProperty());
        Object compareObject = LiteralValue.convertToObject(
                propertyObject.getClass(), getCompareValue());
        return !propertyObject.equals(compareObject);
    }
}
