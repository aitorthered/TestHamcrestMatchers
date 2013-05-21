package test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static es.csd.StringListInAnyOrder.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class TestHamcrest {

	@Test
    public void sameList() {
        List<String> lista1 = Arrays.asList("elm1", "elm2");
        List<String> lista2 = Arrays.asList("elm1", "elm2");
        assertThat(lista1, equalTo(lista2));
    }
	
	@Test
    public void sameListUnordered() {
        List<String> lista1 = Arrays.asList("elm2", "elm1");
        List<String> lista2 = Arrays.asList("elm1", "elm2");
        assertThat(lista1, stringListInAnyOrder(lista2));
    }
}
