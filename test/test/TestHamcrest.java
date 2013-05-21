package test;

import static es.csd.StringListInAnyOrder.stringListInAnyOrder;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestHamcrest {
	List<String> lista1 = Arrays.asList("elm2", "elm1");
	List<String> lista2 = Arrays.asList("elm1", "elm2");

	@Test
	public void sameList() {
		List<String> lista1 = Arrays.asList("elm1", "elm2");
		List<String> lista2 = Arrays.asList("elm1", "elm2");
		assertThat(lista1, equalTo(lista2));
	}

	@Test
	public void testSameNumberOfElements() {
		assertThat(lista1, stringListInAnyOrder(lista2));
		List<String> lista3 = Arrays.asList("elm2", "elm1");
		List<String> lista4 = Arrays.asList("elm1", "elm2", "elm1");
		assertThat(lista3, is(not(stringListInAnyOrder(lista4))));
	}

	@Test
	public void testEmptyList() {
		List<String> lista3 = Arrays.asList();
		List<String> lista4 = Arrays.asList();
		assertThat(lista3, stringListInAnyOrder(lista4));
	}

	@Test
	public void testSameElementsInList() {
		assertThat(lista1, stringListInAnyOrder(lista2));
		List<String> lista3 = Arrays.asList("elm2", "elm1", "elm4");
		List<String> lista4 = Arrays.asList("elm1", "elm2", "elm3");
		assertThat(lista3, is(not(stringListInAnyOrder(lista4))));
	}
}
