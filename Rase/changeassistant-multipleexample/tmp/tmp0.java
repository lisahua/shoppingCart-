@Override public Mapper.Builder parse(String name,Map<String,Object> node,ParserContext parserContext) throws MapperParsingException {
  TTLFieldMapper.Builder builder=new TTLFieldMapper.Builder();
  parseField(builder,builder.name,node,parserContext);
  for (  Map.Entry<String,Object> entry : node.entrySet()) {
    String fieldName=Strings.toUnderscoreCase(entry.getKey());
    Object fieldNode=entry.getValue();
    if (fieldName.equals("enabled")) {
      EnabledAttributeMapper enabledState=nodeBooleanValue(fieldNode) ? EnabledAttributeMapper.ENABLED : EnabledAttributeMapper.DISABLED;
      builder.enabled(enabledState);
    }
 else     if (fieldName.equals("default")) {
      TimeValue ttlTimeValue=nodeTimeValue(fieldNode,null);
      if (ttlTimeValue != null) {
        builder.defaultTTL(ttlTimeValue.millis());
      }
    }
  }
  return builder;
}
