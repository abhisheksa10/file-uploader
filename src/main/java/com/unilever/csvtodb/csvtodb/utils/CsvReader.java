package com.unilever.csvtodb.csvtodb.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.unilever.csvtodb.csvtodb.dto.PersonOutingDTO;

public class CsvReader {

    private byte[] fileAsBytes;
    
    public CsvReader(byte[] fileAsBytes) {
        
        super();
        this.fileAsBytes = fileAsBytes;
    }
    
    public List<PersonOutingDTO> getPersonList() throws IOException {
        
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.typedSchemaFor(PersonOutingDTO.class).withHeader();
        MappingIterator<PersonOutingDTO> personIter = csvMapper.readerFor(PersonOutingDTO.class).with(csvSchema.withColumnSeparator(CsvSchema.DEFAULT_COLUMN_SEPARATOR))
                .readValues(fileAsBytes);
       
        List<PersonOutingDTO> personDetails = new ArrayList<>(personIter.readAll().stream().collect(Collectors.toSet())); // Collecting into a set to remove duplicate entries.
//        Collections.sort(personDetails); //Sort the list using comparator in PersonOutingEntity class

        return personDetails;
    }
}