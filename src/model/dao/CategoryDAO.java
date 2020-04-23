package model.dao;

import java.sql.SQLException;
import java.util.Locale.Category;

public interface CategoryDAO {
	/**
	 * 카테고리추가
	 * @return int - 0: 실패 / 0이 아니면 성공
	 */
	int insert(Category category) throws SQLException;
}
