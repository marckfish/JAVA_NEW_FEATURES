package hm.fr.whilefeature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhileFeatureTest {

    WhileFeature whileFeature;

    @BeforeEach
    public void setUp(){
        whileFeature = new WhileFeature();
    }

    @Test
    public void take_while_all_elements_match(){
        List<Integer> list = whileFeature.takeWhile(Stream.of(2, 4, 6, 8));
        assertEquals(4, list.size());
        assertEquals(2, list.get(0).intValue());
        assertEquals(4, list.get(1).intValue());
        assertEquals(6, list.get(2).intValue());
        assertEquals(8, list.get(3).intValue());
    }

    @Test
    public void take_while_first_element_matchs(){
        List<Integer> list = whileFeature.takeWhile(Stream.of(2, 1, 4, 6, 8));
        assertEquals(1, list.size());
        assertEquals(2, list.get(0).intValue());
    }

    @Test
    public void take_while_first_element_does_not_match(){
        List<Integer> list = whileFeature.takeWhile(Stream.of(3, 0, 2, 6, 8));
        assertEquals(0, list.size());
    }


    @Test
    public void drop_while_all_element_match(){
        List<Integer> list = whileFeature.dropWhile(Stream.of(2, 4, 6, 8));
        assertEquals(0, list.size());
    }

    @Test
    public void drop_while_second_element_does_not_match(){
        List<Integer> list = whileFeature.dropWhile(Stream.of(2, 1, 4, 6, 8));
        assertEquals(4, list.size());
        assertEquals(1, list.get(0).intValue());
        assertEquals(4, list.get(1).intValue());
        assertEquals(6, list.get(2).intValue());
        assertEquals(8, list.get(3).intValue());
    }

    @Test
    public void drop_while_first_element_does_not_match(){
        List<Integer> list = whileFeature.dropWhile(Stream.of(1, 2, 4, 6, 8));
        assertEquals(5, list.size());
        assertEquals(1, list.get(0).intValue());
        assertEquals(2, list.get(1).intValue());
        assertEquals(4, list.get(2).intValue());
        assertEquals(6, list.get(3).intValue());
        assertEquals(8, list.get(4).intValue());
    }
}
