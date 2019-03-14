package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

public class OrderTypeIdResolver extends TypeIdResolverBase {

  private JavaType superType;

  @Override
  public void init(JavaType baseType) {
    superType = baseType;
  }

  @Override
  public String idFromValue(Object obj) {
    return idFromValueAndType(obj, obj.getClass());
  }

  @Override
  public String idFromValueAndType(Object obj, Class<?> subType) {
    return OrderType.fromOrderClass((Class<? extends Order>) subType).toString();
  }

  @Override
  public JavaType typeFromId(DatabindContext context, String id) {
    OrderType type = Enum.valueOf(OrderType.class, id);
    Class<?> subType = type.getOrderClass();
    return context.constructSpecializedType(superType, subType);
  }

  @Override
  public JsonTypeInfo.Id getMechanism() {
    return Id.CUSTOM;
  }
}
