package com.keresman.worms.utility;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public final class FileUtils {

    private FileUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static Optional<File> uploadFile(Window owner, String...extensions) {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
        Stream.of(extensions).forEach(e -> chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(e.toUpperCase(), "*." + e) ));
        return Optional.ofNullable(chooser.showOpenDialog(owner));
    }

    public static void copy(String source, String destination) throws IOException {
        createDirHierarchy(destination);
        Files.copy(Paths.get(source), Paths.get(destination));
    }

    private static void createDirHierarchy(String destination) throws IOException {
        Path dirPath = Paths.get(destination.substring(0, destination.lastIndexOf(File.separator)));
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }
    }
}
