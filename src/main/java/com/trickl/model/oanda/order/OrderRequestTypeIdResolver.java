package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

public class OrderRequestTypeIdResolver extends TypeIdResolverBase {

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
    return OrderRequestType.fromOrderRequestClass((Class<? extends OrderRequest>) subType)
        .toString();
  }

  @Override
  public JavaType typeFromId(DatabindContext context, String id) {
    OrderRequestType type = Enum.valueOf(OrderRequestType.class, id);
    Class<?> subType = type.getOrderRequestClass();
    return context.constructSpecializedType(superType, subType);
  }

  @Override
  public JsonTypeInfo.Id getMechanism() {
    return Id.CUSTOM;
  }
}
