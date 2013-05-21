package es.csd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

public class StringListInAnyOrder extends TypeSafeMatcher<List<String>> {

	List<String> expected;

	public StringListInAnyOrder(List<String> expected) {
		this.expected = expected;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("list ignoring order ");
		description.appendValue(expected);
	}

	@Override
	public boolean matchesSafely(List<String> list) {
		if (this.expected.size() != list.size()) {
			return false;
		}
		List<String> _expected = new ArrayList<String>(expected);
		List<String> _list = new ArrayList<String>(list);
		Collections.sort(_expected);
		Collections.sort(_list);
		return _expected.equals(_list);
	}

	@Factory
	public static Matcher<List<String>> stringListInAnyOrder(
			List<String> expected) {
		return new StringListInAnyOrder(expected);
	}

}