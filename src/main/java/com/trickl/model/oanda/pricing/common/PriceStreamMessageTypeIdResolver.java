package com.trickl.model.oanda.pricing.common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

public class PriceStreamMessageTypeIdResolver extends TypeIdResolverBase {

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
    return PriceStreamMessageType.fromPriceStreamMessageClass(
            (Class<? extends PriceStreamMessage>) subType)
        .toString();
  }

  @Override
  public JavaType typeFromId(DatabindContext context, String id) {
    PriceStreamMessageType type = Enum.valueOf(PriceStreamMessageType.class, id);
    Class<?> subType = type.getPriceStreamMessageClass();
    return context.constructSpecializedType(superType, subType);
  }

  @Override
  public JsonTypeInfo.Id getMechanism() {
    return Id.CUSTOM;
  }
}
