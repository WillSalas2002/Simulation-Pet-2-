package com.will.simulation;

import com.will.simulation.model.Entity;

public class WorldRenderer {

    private final String EMPTY = "⬛";

    public void render(World world) {

        clearConsole();

        System.out.println("====================================================");
        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {
                Coordinate coordinate = new Coordinate(x, y);
                Entity entity = world.findEntityByCoordinate(coordinate);
                if (entity == null) {
                    System.out.print("[" + EMPTY + "]");
                } else {
                    System.out.print("[" + entity + "]");
                }
            }
            System.out.println("|" +y);
        }
    }

    private void clearConsole() {
        // This method will clear the console
        // The implementation may vary depending on the operating system
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
