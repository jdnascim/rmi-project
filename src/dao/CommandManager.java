package dao;

import java.util.HashMap;

public class CommandManager {



    public HashMap<String, Commands> commandMap;

    public CommandManager() {
        commandMap = new HashMap<>();
        commandMap.put("list_all", Commands.LIST_ALL);
        commandMap.put("list_all_from_course", Commands.LIST_FROM_COURSE);
        commandMap.put("list_skills_from_city", Commands.SKILLS_FROM_CITY);
        commandMap.put("add_experience", Commands.ADD_EXPERIENCE);
        commandMap.put("list_profile", Commands.LIST_PROFILE);
        commandMap.put("list_experience_from_user", Commands.EXPERIENCE_PROFILE);

    }

    public static ParsedCommand processCommand(String raw) {
        CommandManager parser = new CommandManager();
        ParsedCommand parsed = new ParsedCommand();
        raw = raw.trim();

        if ( raw.equals("profiles")) {
            parsed.type = Commands.LIST_ALL;
            return parsed;
        }

        String[] aux = raw.split("\\?");
        parsed.type = parser.commandMap.get(aux[0]);
        aux = aux[1].split("=");
        parsed.parameterName = aux[0];
        parsed.value = aux[1].replaceAll("%20", " ");
        return parsed;
    }
}
