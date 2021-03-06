/**
 * Copyright (C) 2009 - 2009 by OpenGamma Inc. and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fudgemsg;

/**
 * A container for all the utilities for working with fudge field prefixes.
 *
 * @author kirk
 */
public final class FudgeFieldPrefixCodec {
  // Yes, these are actually bytes.
  /*package*/ static final int FIELD_PREFIX_FIXED_WIDTH_MASK = 0x80;
  /*package*/ static final int FIELD_PREFIX_ORDINAL_PROVIDED_MASK = 0x10;
  /*package*/ static final int FIELD_PREFIX_NAME_PROVIDED_MASK = 0x08;

  
  private FudgeFieldPrefixCodec() {
  }
  
  public static boolean isFixedWidth(int fieldPrefix) {
    return (fieldPrefix & FIELD_PREFIX_FIXED_WIDTH_MASK) != 0;    
  }

  public static boolean hasOrdinal(int fieldPrefix) {
    return (fieldPrefix & FIELD_PREFIX_ORDINAL_PROVIDED_MASK) != 0;
  }
  
  public static boolean hasName(int fieldPrefix) {
    return (fieldPrefix & FIELD_PREFIX_NAME_PROVIDED_MASK) != 0;
  }
  
  public static int getFieldWidthByteCount(int fieldPrefix) {
    fieldPrefix &= 0x60;
    int count = fieldPrefix >> 5;
    if(count == 3) {
      // We do this because we only have two bits to encode data in.
      // Therefore, we use binary 11 to indicate 4 bytes.
      count = 4;
    }
    return count;
  }
  
  public static int composeFieldPrefix(boolean fixedWidth, int varDataSize, boolean hasOrdinal, boolean hasName) {
    int varDataBits = 0;
    if(!fixedWidth) {
      // This is correct. This is an unsigned value for reading. See note in
      // writeFieldValue.
      if(varDataSize <= 255) {
        varDataSize = 1;
      } else if(varDataSize <= Short.MAX_VALUE) {
        varDataSize = 2;
      } else {
        // Yes, this is right. Remember, we only have 2 bits here.
        varDataSize = 3;
      }
      varDataBits = varDataSize << 5;
    }
    int fieldPrefix = varDataBits;
    if(fixedWidth) {
      fieldPrefix |= FIELD_PREFIX_FIXED_WIDTH_MASK;
    }
    if(hasOrdinal) {
      fieldPrefix |= FIELD_PREFIX_ORDINAL_PROVIDED_MASK;
    }
    if(hasName) {
      fieldPrefix |= FIELD_PREFIX_NAME_PROVIDED_MASK;
    }
    return fieldPrefix;
  }
  
}
