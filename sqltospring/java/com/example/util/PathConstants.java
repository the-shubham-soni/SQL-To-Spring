package com.example.util;

public class PathConstants {
    public static final String SELECT_ALL_USERS = "SELECT * FROM users";
    public static final String GET_USERS_PATH = "/users";
    public static final String UPDATE_USERS_PATH = "/updateUser";
    public static final String INSERT_USERS_PATH = "/insertUser";
    public static final String CORS_PATH = "http://localhost:4200";
    public static final String UPDATE_USER_QUERY = "UPDATE users SET name = ?, email = ? WHERE id = ?";
    public static final String INSERT_USER_QUERY = "INSERT INTO users (name, email) VALUES (?, ?)";
}
