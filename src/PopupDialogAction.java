import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;

public class PopupDialogAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent ) {
        Corona corona = new Corona();
        String coronaData = corona.fajnaMetoda();
        Project currentProject = anActionEvent.getProject();
        Messages.showMessageDialog(currentProject, coronaData, "Ile już jest corony?", Messages.getInformationIcon());
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        e.getPresentation().setEnabledAndVisible(project != null);
    }


}
