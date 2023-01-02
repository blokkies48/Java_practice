import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayLists {
    public static void main(String[] args) 
    {
        // Avoid all logic in main method
        ArrayList<Album> albums1 = createAlbums1();
        task1LogicAlbum1(albums1);
        
        ArrayList<Album> albums2 = createAlbums2(albums1);
        task1LogicAlbum2(albums2);

        search("Dark Side of the Moon", albums2);

    }
    public static ArrayList<Album> createAlbums1() 
    {
        // Initialize ArrayLists of album objects
        ArrayList<Album> albums1 = new ArrayList<Album>();
        // Adding album objects to array list.
        albums1.add(new Album("Curtain Calls", "Eminem", 17));
        albums1.add(new Album("2001", "Dr. Dre", 23));
        albums1.add(new Album("Still I rise", "2pac", 15));
        albums1.add(new Album("D-12 World", "D-12", 20));
        albums1.add(new Album("Radioactive", "Yelawolf", 15));
    
        return albums1;
    }

    public static void task1LogicAlbum1(ArrayList<Album> albums1)
    {

        // Printing each album to console before sorting
        System.out.println("\nUnsorted List:");
        for (Album album : albums1) 
        {
            System.out.println(album);
        }

        // Sorting ArrayList according to number of songs
        // https://www.youtube.com/watch?v=wzWFQTLn8hI
        Collections.sort(albums1, new Comparator<Album>()
        {
            public int compare(Album object1, Album object2) 
            {
                return Integer.valueOf(
                    object1.getNumberOfSongs()
                ).compareTo(object2.getNumberOfSongs());
            }
        });

        // Printing each album to console after sorting
        System.out.println("\nSorted List:");
        for (Album album : albums1) 
        {
            System.out.println(album);
        }

        // Swapping position one with position two
        // Position one = index 0 and position two = index 1
        Collections.swap(albums1, 0, 1);

        // Printing each album to console after Swapping
        System.out.println("\nSwapped Sorted List:");
        for (Album album : albums1) 
        {
            System.out.println(album);
        }
    }

    public static ArrayList<Album> createAlbums2(ArrayList<Album> albums1) {
        // New ArrayList
        ArrayList<Album> albums2 = new ArrayList<Album>();
        // Creating a buffer list to have something to use in addAll method
        ArrayList<Album> bufferAlbumsList = new ArrayList<Album>();
        bufferAlbumsList.add(new Album("Album 1", "Artist 1",15));
        bufferAlbumsList.add(new Album("Album 2", "Artist 2",17));
        bufferAlbumsList.add(new Album("Album 3", "Artist 3",12));
        bufferAlbumsList.add(new Album("Album 4", "Artist 4",18));
        bufferAlbumsList.add(new Album("Album 5", "Artist 5",11));

        // Adding all elements from bufferAlbumsList to album2
        albums2.addAll(bufferAlbumsList);

        // Printing each album to console after adding
        System.out.println("\nAdded List:");
        for (Album album : albums2) {
            System.out.println(album);
        }
        
        // Copying all elements from albums1 to albums2
        Collections.copy(albums2, albums1);

        return albums2;
    }

    public static void task1LogicAlbum2(ArrayList<Album> albums2){
        // Adding extra elements to albums2
        albums2.add(new Album("Dark Side of the Moon", "Pink Floyd", 9));
        albums2.add(new Album("Oops!... I Did It Again", "Britney Spears", 16));

        // Sorting albums alphabetically
        Collections.sort(albums2, new Comparator<Album>() {
            public int compare(Album object1, Album object2) {
                return object1.getAlbumName().compareTo(object2.getAlbumName());
            }
        });
        // Print alphabetically sorted albums 2
        System.out.println("\nAlphabetically Sorted Albums:");
        for (Album album : albums2) {
            System.out.println(album);
        }
    }

    // Searching for album's index
    public static void search(String albumName, ArrayList<Album> albums){
        // Print out the index of the searched album using album name
        int index = 0;
        for (Album album : albums){
            if (album.getAlbumName() == albumName){
                System.out.println("\nThe index of the searched album is: "+ index);
                break;
            }
            index++;
        }
    }
}

class Album {
    // Class variables
    private String albumName;
    private String albumArtist;
    private int numberOfSongs;

    // Constructors
    Album(){}

    Album(String albumName, String albumArtist, int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
        this.albumName = albumName;
        this.albumArtist = albumArtist;
    }

    // Setters
    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    // Getters
    public String getAlbumArtist() {
        return albumArtist;
    }
    public String getAlbumName() {
        return albumName;
    }
    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    // Override methods
    @Override
    public String toString() {
        return "(" + this.albumName + ", " + this.albumArtist + ", " + this.numberOfSongs + ")";
    }
}



