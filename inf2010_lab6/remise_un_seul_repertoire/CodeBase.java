package CircularDeps;

import java.util.HashSet;

public class CodeBase {
    private SourceFile[] sourceFiles;

    public CodeBase(SourceFile[] sourceFiles)
    {
        this.sourceFiles = sourceFiles;
    }

    public boolean hasCircularDependencies()
    {
        for (SourceFile file : this.sourceFiles) {
            HashSet<SourceFile> dependentFiles = new HashSet<>();
            if (existsCircularDependencies(file, dependentFiles)) {
                return true;
            }
        }
        return false;
    }

    // DFS partant de <<file>> détectant s'il existe
    // des dépendances circulaires dans les fichiers source.
    private boolean existsCircularDependencies(SourceFile file, HashSet<SourceFile> dependentFiles)
    {
        // À compléter

        for( SourceFile fileS : file.getDependencies())
             {
                if (fileS.getDependencies().contains(file))
                    return true;
                else
                    for(SourceFile fileD : fileS.getDependencies()){

                        if(fileD.getDependencies().contains(file))
                            return true;
                    }
            }

        return false;
    }
}
