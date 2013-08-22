package jo.sm.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jo.sm.mods.IBlocksPlugin;

public class StarMade
{
    private File  mBaseDir;
    private List<String>    mBlueprints;
    private List<String>    mDefaultBlueprints;
    private List<Entity>    mEntities;
    private ClassLoader     mModLoader;
    private List<IBlocksPlugin> mBlocksPlugins;
    private Properties      mProps;
    
    public StarMade()
    {
        mBlocksPlugins = new ArrayList<IBlocksPlugin>();
    }
    
    public File getBaseDir()
    {
        return mBaseDir;
    }
    public void setBaseDir(File baseDir)
    {
        mBaseDir = baseDir;
    }
    public List<String> getBlueprints()
    {
        return mBlueprints;
    }
    public void setBlueprints(List<String> blueprints)
    {
        mBlueprints = blueprints;
    }
    public List<String> getDefaultBlueprints()
    {
        return mDefaultBlueprints;
    }
    public void setDefaultBlueprints(List<String> defaultBlueprints)
    {
        mDefaultBlueprints = defaultBlueprints;
    }
    public List<Entity> getEntities()
    {
        return mEntities;
    }
    public void setEntities(List<Entity> entities)
    {
        mEntities = entities;
    }
    public ClassLoader getModLoader()
    {
        return mModLoader;
    }
    public void setModLoader(ClassLoader modLoader)
    {
        mModLoader = modLoader;
    }
    public List<IBlocksPlugin> getBlocksPlugins()
    {
        return mBlocksPlugins;
    }
    public void setBlocksPlugins(List<IBlocksPlugin> blocksPlugins)
    {
        mBlocksPlugins = blocksPlugins;
    }

    public Properties getProps()
    {
        return mProps;
    }

    public void setProps(Properties props)
    {
        mProps = props;
    }
}
