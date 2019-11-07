package editor;

import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.JBSplitter;
import com.intellij.ui.components.JBList;
import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.beans.PropertyChangeListener;

public class ChecklistEditor extends UserDataHolderBase implements FileEditor {
    private JComponent component;
    private final JList editor;
    private final JPanel preview;
    private final String name = "ChecklistEditor";

    ChecklistEditor(@NotNull Project project, @NotNull VirtualFile file) {
        this.editor = new JBList();
        this.preview = new JPanel();
    }


    @NotNull
    @Override
    public JComponent getComponent() {
        if (component == null) {
            final JBSplitter splitter = new JBSplitter(false, 0.5f, 0.15f, 0.85f);
            splitter.setSplitterProportionKey(getSplitterProportionKey());
            splitter.setFirstComponent(editor);
            splitter.setSecondComponent(preview);
            component = JBUI.Panels.simplePanel(splitter);
        }
        return component;
    }

    @NotNull
    private String getSplitterProportionKey() {
        return "ChecklistEditor.SplitterProportionKey";
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return editor;
    }

    @NotNull
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void setState(@NotNull FileEditorState state) {

    }

    @Override
    public void selectNotify() {

    }

    @Override
    public void deselectNotify() {

    }

    @Override
    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {

    }

    @Nullable
    @Override
    public BackgroundEditorHighlighter getBackgroundHighlighter() {
        return null;
    }

    @Nullable
    @Override
    public FileEditorLocation getCurrentLocation() {
        return null;
    }

    @Override
    public void dispose() {

    }
}
