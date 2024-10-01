package com.multi.ex05.serial_object_io;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Member implements Serializable{
	// 객체 직렬화(Serializable) Interface 사용하는 법
	// 객체 -> 직렬화 -> 파일(데이터)(통신으로 보낼수 있는) -> 역직렬화 -> 객체
	@Serial
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private int age;
	private String phone;

	public Member() {
		super();
	}

	public Member(String id, String name, int age, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}

}
