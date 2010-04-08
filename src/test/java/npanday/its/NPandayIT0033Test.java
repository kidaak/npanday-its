package npanday.its;

/*
 * Copyright 2010
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

import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;

import java.io.File;

public class NPandayIT0033Test
    extends AbstractNPandayIntegrationTestCase
{
    public NPandayIT0033Test()
    {
        super( "[1.0.2,)" );
    }

    public void testVBSourceWithCsharpTestSource()
        throws Exception
    {
        File testDir = ResourceExtractor.simpleExtractResources( getClass(), "/NPandayIT0033" );
        Verifier verifier = getVerifier( testDir );
        verifier.executeGoal( "install" );
        String assembly = new File( testDir, getAssemblyFile( "NPandayIT0033", "1.0.0.0", "dll" ) ).getAbsolutePath();
        verifier.assertFilePresent( assembly );
        assertClassPresent( assembly, "VBClass" );
        String testAssembly =
            new File( testDir, getTestAssemblyFile( "NPandayIT0033-test", "1.0.0.0", "dll" ) ).getAbsolutePath();
        verifier.assertFilePresent( testAssembly );
        assertClassPresent( testAssembly, "Class1" );
        verifier.verifyErrorFreeLog();
        verifier.resetStreams();
    }
}
