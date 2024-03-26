import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.Serializable;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

/**
 * Exception thrown when there are too many fields in a record.
 */
class TooManyFieldsException extends Exception {
    /**
     * Constructs a new TooManyFieldsException with the specified detail message.
     *
     * @param message the detail message
     */
    public TooManyFieldsException(String message) {
        super(message);
    }
}

/**
 * Exception thrown when there are too few fields in a record.
 */
class TooFewFieldsException extends Exception {
    /**
     * Constructs a new TooFewFieldsException with the specified detail message.
     *
     * @param message the detail message
     */
    public TooFewFieldsException(String message) {
        super(message);
    }
}

/**
 * Exception thrown when a required field is missing in a record.
 */
class MissingFieldException extends Exception {
    /**
     * Constructs a new MissingFieldException with the specified detail message.
     *
     * @param message the detail message
     */
    public MissingFieldException(String message) {
        super(message);
    }
}

/**
 * Exception thrown when the genre of a book is unknown.
 */
class UnknownGenreException extends Exception {
    /**
     * Constructs a new UnknownGenreException with the specified detail message.
     *
     * @param message the detail message
     */
    public UnknownGenreException(String message) {
        super(message);
    }
}

/**
 * Exception thrown when the ISBN-10 of a book is invalid.
 */
class BadIsbn10Exception extends Exception {
    /**
     * Constructs a new BadIsbn10Exception with the specified detail message.
     *
     * @param message the detail message
     */
    public BadIsbn10Exception(String message) {
        super(message);
    }
}

/**
 * Exception thrown when the ISBN-13 of a book is invalid.
 */
class BadIsbn13Exception extends Exception {
    /**
     * Constructs a new BadIsbn13Exception with the specified detail message.
     *
     * @param message the detail message
    */
    public BadIsbn13Exception(String message) {
        super(message);
    }
}

/**
 * Exception thrown when the price of a book is negative.
 */
class BadPriceException extends Exception {
    /**
     * Constructs a new BadPriceException with the specified detail message.
     *
     * @param message the detail message
     */
    public BadPriceException(String message) {
        super(message);
    }
}

/**
 * Exception thrown when the year of a book does not fall within the closed range [1995, 2024].
 */
class BadYearException extends Exception {
    /**
     * Constructs a new BadYearException with the specified detail message.
     *
     * @param message the detail message
     */
    public BadYearException(String message) {
        super(message);
    }
}

/**
 * Represents a book with attributes such as title, authors, price, ISBN, genre, and publication year.
 */
class Book implements Serializable {
    private String title;
    private String authors;
    private double price;
    private String isbn;
    private String genre;
    private int year;

    /**
     * Constructs a new Book object with the specified attributes.
     *
     * @param title   the title of the book
     * @param authors the authors of the book
     * @param price   the price of the book
     * @param isbn    the ISBN of the book
     * @param genre   the genre of the book
     * @param year    the publication year of the book
     */

    public Book(String title, String authors, double price, String isbn, String genre, int year) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.isbn = isbn;
        this.genre = genre;
        this.year = year;
    }

    // Getter and Setter methods

    /**
     * Returns the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the authors of the book.
     *
     * @return the authors of the book
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * Sets the authors of the book.
     *
     * @param authors the authors of the book
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * Returns the price of the book.
     *
     * @return the price of the book
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book.
     *
     * @param price the price of the book
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return the ISBN of the book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn the ISBN of the book
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns the genre of the book.
     *
     * @return the genre of the book
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the book.
     *
     * @param genre the genre of the book
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns the publication year of the book.
     *
     * @return the publication year of the book
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the publication year of the book.
     *
     * @param year the publication year of the book
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Compares this book to the specified object for equality.
     *
     * @param o the object to compare to
     * @return true if the specified object is equal to this book, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(genre, book.genre);
    }

    /**
     * Returns a string representation of the book.
     *
     * @return a string representation of the book
     */
    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Authors: " + authors + "\n" +
                "Price: $" + price + "\n" +
                "ISBN: " + isbn + "\n" +
                "Genre: " + genre + "\n" +
                "Year: " + year + "\n";
    }

}

/**
 * This class contains the main method and functionalities for processing book data.
 */
public class Main {

    /**
     * Processes input files to categorize books based on genre and handle syntax errors.
     */
    public static void do_part1() {

        String[][] genreToFileMapping = initializeGenreMappings();
        PrintWriter[] writers = initializeFileWriters(genreToFileMapping);
        handleInputFiles(writers, genreToFileMapping);
        closeWriters(writers);
    }

    private static void handleInputFiles(PrintWriter[] writers, String[][] genreToFileMapping) {

        Scanner sc = null;
        String fileName;
        String currentLine;
        Scanner bookScanner = null;

        try {
            sc = new Scanner(new FileInputStream("part1_input_file_names.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open input file part1_input_file_names.txt for reading." + " Please check if file exists.");
            System.out.print("Program will terminate.");
            System.exit(0);
        }

        int noOfBooks = sc.nextInt();
        sc.nextLine();

        while (sc.hasNextLine() && noOfBooks != 0) {
            fileName = sc.nextLine();

            try {
                bookScanner = new Scanner(new FileInputStream(fileName.trim()));

            } catch (FileNotFoundException e) {
                System.out.println("Could not find file " + fileName + ", moving on to the next input file.\n");
                continue; // Move to the next file if current file is not found
            }

            while (bookScanner.hasNextLine()) {
                currentLine = bookScanner.nextLine();

                try {
                    String[] fields = currentLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Split by comma, but ignore commas within quotes

                    if (fields.length > 6) {
                        writers[8].println("syntax error in file: " + fileName + "\n==================== \nError: Too many fields \n" +
                                "Record: " + currentLine + "\n");
                        throw new TooManyFieldsException("syntax error in file: " + fileName + "\n==================== \nError: Too many fields \n" +
                                "Record: " + currentLine + "\n");
                    } else if (fields.length < 6) {
                        writers[8].println("syntax error in file: " + fileName + "\n==================== \nError: Too few fields \n" +
                                "Record: " + currentLine + "\n");
                        throw new TooFewFieldsException("syntax error in file: " + fileName + "\n==================== \nError: Too few fields \n" +
                                "Record: " + currentLine + "\n");
                    }

                    for (int i = 0; i < fields.length; i++) {
                        if (fields[i].isEmpty()) {
                            String missingField = "";
                            switch (i) {
                                case 0:
                                    missingField = "name";
                                    break;
                                case 1:
                                    missingField = "authors";
                                    break;
                                case 2:
                                    missingField = "price";
                                    break;
                                case 3:
                                    missingField = "isbn";
                                    break;
                                case 4:
                                    missingField = "genre";
                                    break;
                                case 5:
                                    missingField = "year";
                                    break;
                            }

                            writers[8].println("syntax error in file: " + fileName + "\n==================== \nError: missing " + missingField + "\nRecord: " + currentLine + "\n");
                            throw new MissingFieldException("syntax error in file: " + fileName + "\n==================== \nError: missing " + missingField + "\nRecord: " + currentLine + "\n");
                        }
                    }

                    String genre = fields[4];

                    boolean isValidGenre = false;
                    int outputFileIndex = -1;

                    for (int i = 0; i < 8; i++) {
                        if (genre.equals(genreToFileMapping[0][i])) {
                            isValidGenre = true;
                            outputFileIndex = i;
                            break;
                        }
                    }

                    if (!isValidGenre) {
                        writers[8].println("Error: invalid genre \n" +
                                "Record: " + currentLine + "\n");
                        throw new UnknownGenreException("Error: invalid genre \n" +
                                "Record: " + currentLine + "\n");

                    }

                    writers[outputFileIndex].println(currentLine);
                } catch (TooManyFieldsException e) {
                    System.out.println(e.getMessage());
                } catch (TooFewFieldsException e) {
                    System.out.println(e.getMessage());
                } catch (MissingFieldException e) {
                    System.out.println(e.getMessage());
                } catch (UnknownGenreException e) {
                    System.out.println(e.getMessage());
                }

            }

        }

    }

    /**
     * Initializes PrintWriter objects for writing book records to output files.
     *
     * @param genreToFileMapping a 2D array mapping genre names to corresponding file names
     * @return an array of PrintWriter objects
     */
    private static PrintWriter[] initializeFileWriters(String[][] genreToFileMapping) {
        PrintWriter[] writers = new PrintWriter[9];


        for (int i = 0; i < 8; i++) {
            try {
                writers[i] = new PrintWriter(new FileOutputStream(genreToFileMapping[1][i] + ".txt"));
            } catch (FileNotFoundException e) {
                System.out.println(genreToFileMapping[1][i] + ".txt: Could not open/create the file to write to. Please check for problems such as directory permission or no available memory.");
            }
        }

        try {
            writers[8] = new PrintWriter(new FileOutputStream("syntax_error_file.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("syntax_error_file.txt: Could not open/create the file to write to. Please check for problems such as directory permission or no available memory.");
        }
        return writers;

    }

    /**
     * Initializes mappings between genre names and file names.
     *
     * @return a 2D array containing genre-to-file mappings
     */
    private static String[][] initializeGenreMappings() {
        String[][] genreToFileMapping = new String[2][8];
        genreToFileMapping[0] = new String[]{"CCB", "HCB", "MTV", "MRB", "NEB", "OTR", "SSM", "TPA"};
        genreToFileMapping[1] = new String[]{"Cartoons_Comics_Books.csv", "Hobbies_Collectibles_Books.csv", "Movies_TV.csv", "Music_Radio_Books.csv", "Nostalgia_Eclectic_Books.csv", "Old_Time_Radio.csv", "Sports_Sports_Memorabilia.csv", "Trains_Planes_Automobiles.csv"};
        return genreToFileMapping;
    }

    /**
     * Closes the PrintWriter objects used for writing output files.
     *
     * @param writers an array of PrintWriter objects to be closed
     */
    private static void closeWriters(PrintWriter[] writers) {
        for (PrintWriter writer : writers) {
            writer.close();
        }
    }

    /**
     * Reads CSV files, validates book data, and serializes valid books while handling semantic errors.
     *
     * @throws IOException if an I/O error occurs
     */
    public static void do_part2() throws IOException {

        ObjectOutputStream[] writers = new ObjectOutputStream[8];
        String[] files = new String[8];
        Scanner[] readers = new Scanner[8];
        PrintWriter errorspw = null;

        files[0] = "Cartoons_Comics_Books.csv";
        files[1] = "Hobbies_Collectibles_Books.csv";
        files[2] = "Movies_TV.csv";
        files[3] = "Music_Radio_Books.csv";
        files[4] = "Nostalgia_Eclectic_Books.csv";
        files[5] = "Old_Time_Radio.csv";
        files[6] = "Sports_Sports_Memorabilia.csv";
        files[7] = "Trains_Planes_Automobiles.csv";

        try {
            errorspw = new PrintWriter(new FileOutputStream("semantic_error_file.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open/create the file to write to. "
                    + " Please check for problems such as directory permission"
                    + " or no available memory.");
            System.out.println("System will exit.");
            System.exit(0);
        }

        for (int i = 0; i < 8; i++) {
            try {
                readers[i] = new Scanner(new FileInputStream(files[i] + ".txt"));
                writers[i] = new ObjectOutputStream(new FileOutputStream(files[i] + ".ser"));

                Book[] validBooks = new Book[100];
                int lineNumber = 0;

                while (readers[i].hasNextLine()) {
                    try{
                        String book = readers[i].nextLine();
                        String[] fields = book.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Split by comma, but ignore commas within quotes

                        String title = fields[0].replaceAll("^\"|\"$", ""); // Remove quotes from title if present
                        String authors = fields[1];
                        double price = Double.parseDouble(fields[2]);
                        String isbn = fields[3];
                        String genre = fields[4];
                        int year = Integer.parseInt(fields[5]);

                        String exception = validate(fields);

                        switch (exception) {

                            case "Price":
                                errorspw.println("semantic error in file: " + files[i] + "\n==================== \nError: Wrong Price\nRecord: " + book + "\n");
                                throw new BadPriceException("semantic error in file: " + files[i] + "\n==================== \nError: Wrong Price\nRecord: " + book + "\n");

                            case "ISBN10":
                                errorspw.println("semantic error in file: " + files[i] + "\n==================== \nError: Invalid ISBN-10\nRecord: " + book + "\n");
                                throw new BadIsbn10Exception("semantic error in file: " + files[i] + "\n==================== \nError: Invalid ISBN-10\nRecord: " + book + "\n");

                            case "ISBN13":
                                errorspw.println("semantic error in file: " + files[i] + "\n==================== \nError: Invalid ISBN-13\nRecord: " + book + "\n");
                                throw new BadIsbn13Exception("semantic error in file: " + files[i] + "\n==================== \nError: Invalid ISBN-13\nRecord: " + book + "\n");

                            case "Year":
                                errorspw.println("semantic error in file: " + files[i] + "\n==================== \nError: Invalid year\nRecord: " + book + "\n");
                                throw new BadYearException("semantic error in file: " + files[i] + "\n==================== \nError: Invalid year\nRecord: " + book + "\n");

                            default:
                                Book bookObject = new Book(title, authors, price, isbn, genre, year);

                                if(lineNumber >= validBooks.length){
                                    Book[] tempArray = new Book[validBooks.length*2];
                                    System.arraycopy(validBooks, 0, tempArray, 0, validBooks.length);
                                    validBooks = tempArray;
                                }

                                validBooks[lineNumber] = bookObject;
                                lineNumber++;
                        }

                    } catch (BadIsbn10Exception e) {
                        System.out.println(e.getMessage());
                    } catch (BadIsbn13Exception e) {
                        System.out.println(e.getMessage());
                    } catch (BadPriceException e) {
                        System.out.println(e.getMessage());
                    } catch (BadYearException e) {
                        System.out.println(e.getMessage());
                    }

                }

                System.out.println("Line: " + lineNumber);

                //Write valid books to the binary file
                for (int l = 0; l < lineNumber; l++) {
                    writers[i].writeObject(validBooks[l]);
                }

            }
            catch (FileNotFoundException e) {
                System.out.println("Could not find file " + files[i] + ", moving on to the next input file.");
            } catch (IOException io) {
                System.out.println("Could not open/create the file to write to. "
                        + " Please check for problems such as directory permission"
                        + " or no available memory.");
                continue;
            }

        }

        errorspw.close();

        for (ObjectOutputStream writer : writers) {
            writer.close();
        }

    }

    /**
     * Validates the fields of a book record for semantic errors and returns an error message if validation fails.
     *
     * @param fields an array containing the fields of a book record
     * @return an error message if validation fails, or an empty string if validation succeeds
     */
    private static String validate(String[] fields) {

        double price = Double.parseDouble(fields[2]);

        if (price < 0) {
            return "Price";
        }

        String isbn = fields[3];

        int[] isbnArr = new int[isbn.length()];

        for (int j = 0; j < isbn.length(); j++) {
            char c = isbn.charAt(j);
            isbnArr[j] = Character.getNumericValue(c);
        }

        if (isbn.length() == 10) {
            int sum = 0;
            for (int k = 10; k > 0; k--) {
                sum = sum + (k * isbnArr[10 - k]);
            }

            if (sum % 11 != 0) {
                return "ISBN10";

            }
        } else if (isbn.length() == 13) {
            int sum = 0;
            for (int k = 0; k < 13; k++) {
                if (k % 2 == 1) {
                    sum = sum + (3 * isbnArr[k]);
                } else {
                    sum = sum + isbnArr[k];
                }
            }

            if (sum % 10 != 0) {
                return "ISBN13";
            }
        }

        int year = Integer.parseInt(fields[5]);

        if(year < 1995 || year > 2024){
            return "Year";
        }

        return "";
    }

    /**
     * Deserializes books from binary files and provides a navigation system to view the data interactively.
     *
     * @throws IOException if an I/O error occurs
     */
    public static void do_part3() throws IOException {

        String[] files = {
                "Cartoons_Comics_Books.csv.ser",
                "Hobbies_Collectibles_Books.csv.ser",
                "Movies_TV.csv.ser",
                "Music_Radio_Books.csv.ser",
                "Nostalgia_Eclectic_Books.csv.ser",
                "Old_Time_Radio.csv.ser",
                "Sports_Sports_Memorabilia.csv.ser",
                "Trains_Planes_Automobiles.csv.ser"
        };

        ObjectInputStream[] objectReaders = new ObjectInputStream[8];
        Book[][] bookArray = new Book[8][];

        for (int i = 0; i < 8; i++) {
            try {
                objectReaders[i] = new ObjectInputStream(new FileInputStream(files[i]));

                Book[] books = new Book[100];
                int index = 0;
                Book currentBook;

                while (true) {
                    try {
                        currentBook = (Book) objectReaders[i].readObject();
                        if (index >= books.length) {
                            Book[] temp = new Book[books.length * 2];
                            System.arraycopy(books, 0, temp, 0, books.length);
                            books = temp;
                        }
                        books[index++] = currentBook;
                    } catch (EOFException e) {
                        // End of file reached, exit the loop
                        break;
                    }
                }
                bookArray[i] = new Book[index];
                System.arraycopy(books, 0, bookArray[i], 0, index);
            } catch (IOException e) {
                System.out.println("Could not open the file " + files[i]);
            } catch (ClassNotFoundException e) {
                System.out.println("Invalid class object in " + files[i]);
            }

        }

        for(ObjectInputStream ois: objectReaders ){
            ois.close();
        }

        //Go to navigation
        navigation(bookArray, files);
    }

    /**
     * Displays the main menu and handles user input for file selection and navigation.
     *
     * @param bookArray an array of Book arrays containing book records
     * @param files     an array of file names corresponding to the book records
     */
    public static void navigation(Book[][] bookArray, String[] files){
        Scanner kb = new Scanner(System.in);
        int fileIndex = 0;

        while (true){
            String mmChoice = displayMainMenu(files[fileIndex] + " (" + bookArray[fileIndex].length + " records)", kb);
            if(mmChoice.equals("s")){
                int subMenuChoice = displaySubMenu(bookArray, files, kb) - 1;
                if(subMenuChoice == 8){
                    continue;
                }
                else{
                    fileIndex = subMenuChoice;
                    continue;
                }

            } else if (mmChoice.equals("x")) {
                System.out.println("You chose to exit, exiting the program.");
                System.exit(0);
            } else {
                viewFile(bookArray[fileIndex], files[fileIndex] + " (" + bookArray[fileIndex].length + " records)", kb);
                continue;
            }
        }
    }

    /**
     * Displays the main menu and handles user interaction.
     *
     * @param fileDetails details about the current file being viewed
     * @param kb scanner object for user input
     * @return the user's choice
     */
    public static String displayMainMenu(String fileDetails, Scanner kb){

        System.out.println("\n-----------------------------\n" +
                "         Main Menu         \n"+
                "-----------------------------\n" +
                "v View the selected file: " + fileDetails +"\n" +
                "s Select a file to view\n" +
                "x Exit\n" +
                "-----------------------------\n");

        while (true){

            System.out.print("Enter your choice: ");
            String choice = kb.nextLine().trim().toLowerCase();

            if (choice.length() == 1 && (choice.equals("v") || choice.equals("s") || choice.equals("x"))) {
                return choice;
            }
            else{
                System.out.println("Invalid choice. Please enter 'v', 's', or 'x'.");
            }
        }

    }

    /**
     * Displays the file sub-menu and handles user interaction.
     *
     * @param bookArray array containing book data
     * @param files array of file names
     * @param kb scanner object for user input
     * @return the user's choice
     */
    public static int displaySubMenu(Book[][] bookArray, String[] files, Scanner kb){
        String[] options = {
                "1  Cartoons_Comics_Books.csv.ser  (" + bookArray[0].length + " records)",
                "2  Hobbies_Collectibles_Books.csv.ser  (" + bookArray[1].length + " records)",
                "3  Movies_TV.csv.ser  (" + bookArray[2].length + " records)",
                "4  Music_Radio_Books.csv.ser  (" + bookArray[3].length + " records)",
                "5  Nostalgia_Eclectic_Books.csv.ser  (" + bookArray[4].length + " records)",
                "6  Old_Time_Radio.csv.ser  (" + bookArray[5].length + " records)",
                "7  Sports_Sports_Memorabilia.csv.ser  (" + bookArray[6].length + " records)",
                "8  Trains_Planes_Automobiles.csv.ser  (" + bookArray[7].length + " records)",
                "9  Exit"
        };
        System.out.println("\n-----------------------------\n" +
                "         File Sub-Menu         \n"+
                "-----------------------------\n");

        for(String option: options){
            System.out.println(option);
        }
        System.out.println("-----------------------------");

        while (true){
            System.out.println();
            System.out.print("Enter your choice: ");
            String choice = kb.nextLine().trim().toLowerCase();

            // Check if the input is a valid number
            if (!choice.matches("\\d+")) {
                System.out.println("Invalid choice. Please enter a digit between 1 and 9");
                continue; // Restart the loop to prompt the user again
            }

            if (choice.length() > 1) {
                System.out.println("Invalid choice. Please enter a digit between 1 and 9");
            } else if ((Integer.parseInt(choice) > 0 && Integer.parseInt(choice) < 10  )) {
                return Integer.parseInt(choice);
            } else{
                System.out.println("Invalid choice. Please enter a digit between 1 and 9");
            }
        }
    }

    /**
     * Allows users to view the contents of a file interactively.
     *
     * @param bookFile   array containing book data from the selected file
     * @param fileString string representation of the file being viewed
     * @param kb         scanner object for user input
     */
    public static void viewFile(Book[] bookFile, String fileString, Scanner kb){
        System.out.println("\nviewing: " + fileString);
        int size = bookFile.length;
        int currentBookIndex = 0;
        int lastBookIndex = 0;
        int topBookIndex = 0;
        boolean eof = false;
        boolean bof = false;

        while (true){

            System.out.println();

            if(bof){
                System.out.println("BOF has been reached\n");
            }

            for(int i = topBookIndex; i < lastBookIndex+1; i++){
                Book bk = bookFile[i];
                System.out.println(bk.toString());
            }

            if(eof){
                System.out.println("EOF has been reached");
            }

            int n;

            while (true) {
                System.out.print("Enter n ");
                String userInput = kb.nextLine();

                try {
                    n = Integer.parseInt(userInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }

            if(n == 0){
                break;
            }
            else if (n > 0) {
                if (n == 1) {
                    topBookIndex = currentBookIndex;
                    lastBookIndex = currentBookIndex;
                    eof = false;
                    bof = false;
                }
                else{
                    if((currentBookIndex + n - 1) > size-1){
                        topBookIndex = currentBookIndex;
                        lastBookIndex = (size - 1);
                        currentBookIndex = lastBookIndex;
                        eof = true;
                        bof = false;
                    }
                    else{
                        topBookIndex = currentBookIndex;
                        lastBookIndex = currentBookIndex + n - 1;
                        currentBookIndex = lastBookIndex;
                        eof = false;
                        bof = false;
                    }
                }

            } else {
                if (n == -1) {
                    topBookIndex = currentBookIndex;
                    lastBookIndex = currentBookIndex;
                    eof = false;
                    bof = false;
                }
                else{
                    if (currentBookIndex + n + 1 < 0){
                        lastBookIndex = currentBookIndex;
                        topBookIndex = 0;
                        currentBookIndex = topBookIndex;
                        bof = true;
                        eof = false;
                    }
                    else{
                        lastBookIndex = currentBookIndex;
                        topBookIndex = currentBookIndex + n + 1;
                        currentBookIndex = topBookIndex;
                        bof = false;
                        eof = false;
                    }
                }
            }
        }
    }

    /**
     * Main method to execute the book processing functionalities.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if an I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        do_part1();
        do_part2();
        do_part3();
    }
}
