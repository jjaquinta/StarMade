package jo.sm.logic;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.jar.Manifest;

import jo.sm.data.StarMade;
import jo.sm.mods.IBlocksPlugin;
import jo.sm.mods.IStarMadePlugin;

public class StarMadeLogic
{
    private static StarMade mStarMade;
    
    public static synchronized StarMade getInstance()
    {
        if (mStarMade == null)
        {
            mStarMade = new StarMade();
        }
        return mStarMade;
    }
    
    public static void setBaseDir(String baseDir)
    {
        File bd = new File(baseDir);
        if (!bd.exists())
            throw new IllegalArgumentException("Base directory '"+baseDir+"' does not exist");
        getInstance().setBaseDir(bd);
        List<String> blocksPlugins = new ArrayList<String>();
        discoverPlugins(baseDir, blocksPlugins);
        loadPlugins(blocksPlugins);
    }
    
    private static void loadPlugins(List<String> blocksPlugins)
    {
        for (String blocksPluginClassName : blocksPlugins)
        {
            try
            {
                Class<?> blocksPluginClass = getInstance().getModLoader().loadClass(blocksPluginClassName);
                if (blocksPluginClass == null)
                    continue;
                IBlocksPlugin plugin = (IBlocksPlugin)blocksPluginClass.newInstance();
                if (plugin == null)
                    continue;
                getInstance().getBlocksPlugins().add(plugin);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private static void discoverPlugins(String baseDir,
            List<String> blocksPlugins)
    {
        List<URL> urls = new ArrayList<URL>();
        File pluginDir = new File(baseDir, "jo_plugins");
        if (pluginDir.exists())
            for (File jar : pluginDir.listFiles())
                if (jar.getName().endsWith(".jar"))
                {
                    try
                    {
                        URL url = jar.toURI().toURL();
                        urls.add(url);
                        URL jarURL = new URL("jar:"+url.toString()+"!/");
                        JarURLConnection jarConnection = (JarURLConnection)jarURL.openConnection();
                        Manifest manifest = jarConnection.getManifest();
                        String plugins = manifest.getMainAttributes().getValue("BlocksPlugins");
                        if (plugins != null)
                            for (StringTokenizer st = new StringTokenizer(plugins, ","); st.hasMoreTokens(); )
                            {
                                String plugin = st.nextToken();
                                blocksPlugins.add(plugin);
                            }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
        // instantiate plugins
        URLClassLoader modLoader = new URLClassLoader(urls.toArray(new URL[0]), StarMadeLogic.class.getClassLoader());
        getInstance().setModLoader(modLoader);
    }
    
    public static List<IBlocksPlugin> getBlocksPlugins(int type, int subtype)
    {
        List<IBlocksPlugin> plugins = new ArrayList<IBlocksPlugin>();
        for (IBlocksPlugin plugin : getInstance().getBlocksPlugins())
            if (isPlugin(plugin, type, subtype))
                plugins.add(plugin);
        return plugins;
    }
    
    private static boolean isPlugin(IStarMadePlugin plugin, int type, int subtype)
    {
        try
        {   // lets be protective against badly written plugins
            for (int[] classification : plugin.getClassifications())
                if ((type == -1) || (type == classification[0]))
                    if ((subtype == -1) || (subtype == classification[1]))
                        return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isStarMadeDirectory(String dir)
    {
        File d = new File(dir);
        if (!d.exists())
            return false;
        File smJar = new File(d, "StarMade.jar");
        return smJar.exists();
    }
}
