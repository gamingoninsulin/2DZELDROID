package me.gamingoninsulin.tiles;

import me.gamingoninsulin.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    Tile[] tiles;
    int mapTileNum[] [];


    public TileManager(GamePanel gp) {

        this.gp = gp;
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        tiles = new Tile[32];

        getTileImage();
        loadMap("../res/maps/Map02.txt");
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row< gp.maxWorldRow) {
                String line = br.readLine();

                while(col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                    if (col == gp.maxWorldCol) {
                        col = 0;
                        row++;
                    }
                }
                br.close();
            }

        }catch (Exception e){
        }
    }

    public void getTileImage() {
        try {

// mixed tiles #############
            System.out.println("loading Mixed tiles");

            //grass tile 00
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/grass00.png"));

            //grass tile 01
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/grass01.png"));

            //earth tile
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/earth.png"));

            //tree tile
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/tree.png"));

            //wall tile
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/wall.png"));

// Road tiles #############
            System.out.println("loading Road tiles");

            //road tile 00
            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road00.png"));

            //road tile 01
            tiles[6] = new Tile();
            tiles[6].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road01.png"));

            //road tile 02
            tiles[7] = new Tile();
            tiles[7].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road02.png"));

            //road tile 03
            tiles[8] = new Tile();
            tiles[8].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road03.png"));

            //road tile 04
            tiles[9] = new Tile();
            tiles[9].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road04.png"));

            //road tile 05
            tiles[10] = new Tile();
            tiles[10].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road05.png"));

            //road tile 06
            tiles[11] = new Tile();
            tiles[11].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road06.png"));

            //road tile 07
            tiles[12] = new Tile();
            tiles[12].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road07.png"));

            //road tile 08
            tiles[13] = new Tile();
            tiles[13].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road08.png"));

            //road tile 08
            tiles[14] = new Tile();
            tiles[14].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road09.png"));

            //road tile 10
            tiles[15] = new Tile();
            tiles[15].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road10.png"));

            //road tile 11
            tiles[16] = new Tile();
            tiles[16].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road11.png"));

            //road tile 12
            tiles[17] = new Tile();
            tiles[17].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/road12.png"));

// Water Tiles #############
            System.out.println("loading Water tiles");

            //water tile 00
            tiles[18] = new Tile();
            tiles[18].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water00.png"));

            //water tile 01
            tiles[19] = new Tile();
            tiles[19].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water01.png"));

            //water tile 02
            tiles[20] = new Tile();
            tiles[20].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water02.png"));

            //water tile 03
            tiles[21] = new Tile();
            tiles[21].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water03.png"));

            //water tile 04
            tiles[22] = new Tile();
            tiles[22].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water04.png"));


            //water tile 05
            tiles[23] = new Tile();
            tiles[23].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water05.png"));

            //water tile 06
            tiles[24] = new Tile();
            tiles[24].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water06.png"));

            //water tile 07
            tiles[25] = new Tile();
            tiles[25].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water07.png"));

            //water tile 08
            tiles[26] = new Tile();
            tiles[26].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water08.png"));

            //water tile 09
            tiles[27] = new Tile();
            tiles[27].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water09.png"));

            //water tile 10
            tiles[28] = new Tile();
            tiles[28].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water10.png"));

            //water tile 11
            tiles[29] = new Tile();
            tiles[29].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water11.png"));

            //water tile 12
            tiles[30] = new Tile();
            tiles[30].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water12.png"));

            //water tile 13
            tiles[31] = new Tile();
            tiles[31].image = ImageIO.read(getClass().getResourceAsStream("../res/tiles/water13.png"));
            System.out.println("loading tile complete!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol <gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenY;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            worldCol++;

            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
