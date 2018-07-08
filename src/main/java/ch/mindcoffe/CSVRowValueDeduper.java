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

import java.io.IOException;

/**
 * This Tool aims to remove duplicate values from lines in a csv file.
 * The File will be parsed line by line and all elements of the row will be put into a set. Only unique values will
 * remain
 */
public class CSVRowValueDeduper {
    public static void main(String[] args) throws IOException {
        CSVParser csvParser = new CSVParser();
        if (args.length == 0) {
            System.out.println("The CSV Duplicate Remover requieres two arguments 'input Path' and 'output path'");
        }
        if (args.length >= 2) {
            csvParser.handleFile(args[0], args[1]);

        }

    }
}
