package model.dao;

import java.sql.SQLException;
import java.util.Locale.Category;

public interface CategoryDAO {
	/**
	 * ī�װ��߰�
	 * @return int - 0: ���� / 0�� �ƴϸ� ����
	 */
	int insert(Category category) throws SQLException;
}
