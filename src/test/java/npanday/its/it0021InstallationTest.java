package npanday.its;

/*
 * Copyright 2009
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
import org.apache.maven.it.util.ResourceExtractor;

public class it0021InstallationTest
    extends AbstractNPandayIntegrationTestCase
{
    public it0021InstallationTest()
    {
        super( "(1.0,)" ); // 1.0.1+
    }

    public void verifyInstalledResources()
        throws Exception
    {
        File testDir = ResourceExtractor.simpleExtractResources( getClass(), "/it0021" );
        Verifier verifier = getVerifier( testDir );
        verifier.executeGoal( "install" );
        verifier.assertFilePresent( new File( testDir + "/" +
            getAssemblyFile( "NPanday.IT.0021", "dll" ) ).getAbsolutePath() );
		verifier.assertFilePresent( new File( testDir + "/" + "assembly-resources/" +
            getAssemblyFile( "NPanday.IT.0021", "resx" ) ).getAbsolutePath() );
		verifier.assertFilePresent( new File( testDir + "/" + "assembly-resources/resource" +
            getAssemblyFile( "NPanday.IT.0021", "resources" ) ).getAbsolutePath() );
		verifier.verifyErrorFreeLog();
        verifier.resetStreams();
    }
}
