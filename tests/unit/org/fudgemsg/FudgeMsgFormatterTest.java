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

import java.io.PrintWriter;

import org.fudgemsg.FudgeMsg;
import org.fudgemsg.FudgeMsgFormatter;
import org.junit.Test;

/**
 * 
 *
 * @author kirk
 */
public class FudgeMsgFormatterTest {
  
  /**
   * Will output a {@link FudgeMsg} to {@code System.out} so that you can visually
   * examine it.
   */
  @Test
  public void outputToStdoutAllNames() {
    System.out.println("FudgeMsgFormatterTest.outputToStdoutAllNames()");
    FudgeMsg msg = StandardFudgeMessages.createMessageAllNames();
    msg.add("Sub Message", 9999, StandardFudgeMessages.createMessageAllNames());
    (new FudgeMsgFormatter(new PrintWriter(System.out))).format(msg);
  }
  
  /**
   * Will output a {@link FudgeMsg} to {@code System.out} so that you can visually
   * examine it.
   */
  @Test
  public void outputToStdoutAllOrdinals() {
    System.out.println("FudgeMsgFormatterTest.outputToStdoutAllOrdinals()");
    FudgeMsg msg = StandardFudgeMessages.createMessageAllOrdinals();
    msg.add("Sub Message", 9999, StandardFudgeMessages.createMessageAllOrdinals());
    (new FudgeMsgFormatter(new PrintWriter(System.out))).format(msg);
  }

}
