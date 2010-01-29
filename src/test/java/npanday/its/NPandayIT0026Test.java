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

import java.io.File;

import org.apache.maven.it.Verifier;
import org.apache.maven.it.VerificationException;
import org.apache.maven.it.util.ResourceExtractor;

public class NPandayIT0026Test
    extends AbstractNPandayIntegrationTestCase
{
    public NPandayIT0026Test()
    {
        super( "(1.1,)" );
    }

    public void testVerifyIT0026()
        throws Exception
    {
        File testDir = ResourceExtractor.simpleExtractResources( getClass(), "/NPandayIT0026" );
        Verifier verifier = getVerifier( testDir );
		verifier.executeGoal( "install" );
		verifier.assertFilePresent( new File( testDir + "/" +
			getAssemblyFile( "NPandayIT0026", "1.0.0.0", "dll", null ) ).getAbsolutePath() );
		verifier.verifyErrorFreeLog();
		verifier.resetStreams();
    }
}
