/**
 * Copyright (C) 2009 - 2009 by OpenGamma Inc.
 *
 * Please see distribution for license.
 */
package com.opengamma.fudge.types;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.opengamma.fudge.FudgeFieldType;
import com.opengamma.fudge.FudgeTypeDictionary;

/**
 * 
 *
 * @author kirk
 */
public class ByteArrayFieldType extends FudgeFieldType<byte[]> {
  public static final ByteArrayFieldType INSTANCE = new ByteArrayFieldType();
  
  public ByteArrayFieldType() {
    super(FudgeTypeDictionary.BYTE_ARRAY_TYPE_ID, byte[].class, true, 0);
  }

  @Override
  public int getVariableSize(byte[] value) {
    return value.length;
  }

  @Override
  public byte[] readValue(DataInput input, int dataSize) throws IOException {
    byte[] result = new byte[dataSize];
    input.readFully(result);
    return result;
  }

  @Override
  public void writeValue(DataOutput output, byte[] value) throws IOException {
    output.write(value);
  }

}