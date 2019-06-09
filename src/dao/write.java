package dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import bean.user;
import dao.utils;

public class write {
	protected static void write_db(ArrayList<user> users) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(utils.getPathYML()))) {

        	br.write("profiles:\n");
            br.write(dao.utils.arrayLUserstoString(users));
            br.write('\n');

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
	}
}
