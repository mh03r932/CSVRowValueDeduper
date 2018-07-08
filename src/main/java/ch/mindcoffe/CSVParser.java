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

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.LinkedHashSet;
import java.util.Set;

public class CSVParser {


    CSVParser() {
    }

    void handleFile(String fileInPath, String fileOutPath) throws IOException {

        try (CSVPrinter csvPrinter = CSVFormat.DEFAULT.print(new File(fileOutPath), Charset.defaultCharset())) {
            try (Reader in = new FileReader(fileInPath)) {
                Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
                for (CSVRecord record : records) {
                    Set<String> rowWithoutDups = this.removeDuplicatesFromRecord(record);
                    this.writeAsOutAsCSV(rowWithoutDups, csvPrinter);
                }

            }
        }


    }

    private void writeAsOutAsCSV(Set<String> rowWithoutDups, CSVPrinter csvPrinter) throws IOException {
        csvPrinter.printRecord(rowWithoutDups);
    }

    public Set<String> removeDuplicatesFromRecord(Iterable<String> record) {
        Set<String> uniqueValues = new LinkedHashSet<>();
        for (String value : record) {
            uniqueValues.add(value);
        }
        return uniqueValues;

    }


}
