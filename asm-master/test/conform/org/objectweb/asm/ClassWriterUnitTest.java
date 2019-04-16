/***
 * ASM tests
 * Copyright (c) 2000-2011 INRIA, France Telecom
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holders nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.objectweb.asm;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassWriter unit tests.
 * 
 * @author Eric Bruneton
 */
public class ClassWriterUnitTest extends TestCase {

    public void testNewConst() {
        ClassWriter cw = new ClassWriter(0);
        cw.newConst(new Byte((byte) 0));
        cw.newConst(new Character('0'));
        cw.newConst(new Short((short) 0));
        cw.newConst(Boolean.FALSE);
        cw.newField("A", "f", "I");
        cw.newMethod("A", "m", "()V", false);
    }

    public void testIllegalNewConstArgument() {
        ClassWriter cw = new ClassWriter(0);
        try {
            cw.newConst(new Object());
            fail();
        } catch (RuntimeException e) {
        }
    }

    public void testIllegalGetCommonSuperClassArguments() {
        ClassWriter cw = new ClassWriter(0);
        try {
            cw.getCommonSuperClass("-", "-");
            fail();
        } catch (RuntimeException e) {
        }
    }

}
