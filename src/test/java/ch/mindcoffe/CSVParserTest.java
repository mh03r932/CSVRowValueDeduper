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
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

public class CSVParserTest {

    private CSVParser parser;

    @Before
    public void setUp() {
        parser = new CSVParser();

    }

    @Test
    public void removeDuplicatesFromRecord() {
        String[] recordToDeDupe = {"0", "1", "2", "3", "2", "1", "1", "3", "4", "5", "4", "4", "6", "7", "7", "6", "1", "2", "4", "8", "8", "9"};

        Set<String> strings = parser.removeDuplicatesFromRecord(Arrays.asList(recordToDeDupe));
        int indexnum = 0;
        for (String next : strings) {
            Assert.assertEquals(next, String.valueOf(indexnum));
            indexnum++;

        }
    }
}