/*
 * Copyrigh 2018. mh03r932
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

package ch.mindcoffe;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Unit test for simple CSVRowValueDeduper.
 */
public class CSVRowValueDeduperTest {

    @Test
    public void shouldNotLooseLines() throws IOException {
        checkSameNumberOfLines(".\\src\\test\\resources\\input1.csv", ".\\target\\output1.csv");
        checkSameNumberOfLines(".\\src\\test\\resources\\input2.csv", ".\\target\\output2.csv");
        checkSameNumberOfLines(".\\src\\test\\resources\\input3.csv", ".\\target\\output3.csv");
        checkSameNumberOfLines(".\\src\\test\\resources\\input4.csv", ".\\target\\output4.csv");

    }

    @Test
    public void shouldChangeNothin() throws IOException {
        checkSameNumberOfLines(".\\src\\test\\resources\\noop.csv", ".\\target\\noop.csv");

    }

    private void checkSameNumberOfLines(String in, String out) throws IOException {
        CSVParser csvParser = new CSVParser();
        csvParser.handleFile(in, out);
        Stream<String> linesIn = Files.lines(Paths.get(in));
        Stream<String> linesOut = Files.lines(Paths.get(out));
        Assert.assertEquals(linesIn.count(), linesOut.count());

    }

    private void checkNoOp(String in, String out) throws IOException {
        CSVParser csvParser = new CSVParser();
        csvParser.handleFile(in, out);
        Stream<String> linesIn = Files.lines(Paths.get(in));
        Stream<String> linesOut = Files.lines(Paths.get(out));
        Assert.assertEquals(linesIn.count(), linesOut.count());
        Assert.assertTrue(linesIn.findFirst().isPresent());
        Assert.assertTrue(linesOut.findFirst().isPresent());
        Assert.assertEquals(linesOut.findFirst().get(), linesIn.findFirst().get());

    }
}
