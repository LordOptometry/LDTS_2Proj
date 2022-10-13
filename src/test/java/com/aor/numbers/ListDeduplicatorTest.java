package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    List<Integer> list;
    List<Integer> expected;
    @BeforeEach
    public void Helper() {
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }


    @Test
    public void deduplicate() {
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4, 5));
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void bug_deduplicate_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);
        expected = Arrays.asList(1,2,4);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void use_deduplicate(){
        expected = Arrays.asList(1,2,4,6);
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        ListDeduplicator dedu = new ListDeduplicator(sorter);
        Mockito.when(dedu.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4, 6));
        List<Integer> end = dedu.deduplicate(list);
        Assertions.assertEquals(expected, end);
    }
}