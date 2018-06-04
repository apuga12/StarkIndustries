package mx.book.ajax.repository3;

import java.util.List;

import mx.book.ajax.domain3.TestCat;
import mx.book.ajax.domain3.TestLibs;

public interface BookAjaxRestDao {
	
	public String selectNextPalabraPredictiva(String dato);
	public List<TestCat> selectAll();
	public List<TestLibs> selectByTheme(int sel);
}
