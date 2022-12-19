package raf.dsw.gerumap.mapRepository;

import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.mapRepository.commands.CommandManager;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

/**
 * Ovde pravimo projectExplorer koji ce se kasnije postavljati dok tree
 */
public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;
    private CommandManager commandManager;

    public MapRepositoryImpl() {
        this.projectExplorer = new ProjectExplorer("My Project Explorer");
        this.commandManager = new CommandManager();
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

}
