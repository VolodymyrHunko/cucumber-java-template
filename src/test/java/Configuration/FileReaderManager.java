package Configuration;

/*
    Singleton class to manage all File Readers
 */
public class FileReaderManager {
    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    //constructor is private
    private FileReaderManager(){}

    //static instance of class
    public static FileReaderManager getInstance(){
        return  fileReaderManager;
    }
    //methods of singleton class
    public ConfigFileReader getConfigFileReader(){
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}
