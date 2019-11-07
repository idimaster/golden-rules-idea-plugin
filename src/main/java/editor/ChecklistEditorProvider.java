package editor;

import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.fileEditor.FileEditorProvider;
import com.intellij.openapi.fileTypes.BinaryFileTypeDecompilers;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ChecklistEditorProvider implements FileEditorProvider, DumbAware {
    @NonNls
    private static final String EDITOR_TYPE_ID = "checklists";
    @Override
    public boolean accept(@NotNull Project project, @NotNull VirtualFile file) {
        return isTextFile(file);
    }

    public static boolean isTextFile(@NotNull VirtualFile file) {
        if (file.isDirectory() || !file.isValid()) {
            return false;
        }

        final FileType ft = file.getFileType();
        return !ft.isBinary() || BinaryFileTypeDecompilers.INSTANCE.forFileType(ft) != null;
    }

    @NotNull
    @Override
    public FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile file) {
        return new ChecklistEditor(project, file);
    }

    @NotNull
    @Override
    public String getEditorTypeId() {
        return EDITOR_TYPE_ID;
    }

    @NotNull
    @Override
    public FileEditorPolicy getPolicy() {
        return FileEditorPolicy.HIDE_DEFAULT_EDITOR;
    }
}
