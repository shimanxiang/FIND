package common.servicebase;

import java.io.Serializable;
import java.util.List;

import find.entity.User;
import find.responseentity.BaseUserInfoMsg;

public interface BaseService <T extends Serializable>{
	void add(T t);
	void update(T t);
	void remove(T t);
}
