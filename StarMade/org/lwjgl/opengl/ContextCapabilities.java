/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import org.lwjgl.LWJGLException;
/*      */ import org.lwjgl.LWJGLUtil;
/*      */ 
/*      */ public class ContextCapabilities
/*      */ {
/*      */   static final boolean DEBUG = false;
/*   12 */   final APIUtil util = new APIUtil();
/*   13 */   final StateTracker tracker = new StateTracker();
/*      */   public final boolean GL_AMD_blend_minmax_factor;
/*      */   public final boolean GL_AMD_conservative_depth;
/*      */   public final boolean GL_AMD_debug_output;
/*      */   public final boolean GL_AMD_depth_clamp_separate;
/*      */   public final boolean GL_AMD_draw_buffers_blend;
/*      */   public final boolean GL_AMD_multi_draw_indirect;
/*      */   public final boolean GL_AMD_name_gen_delete;
/*      */   public final boolean GL_AMD_performance_monitor;
/*      */   public final boolean GL_AMD_pinned_memory;
/*      */   public final boolean GL_AMD_query_buffer_object;
/*      */   public final boolean GL_AMD_sample_positions;
/*      */   public final boolean GL_AMD_seamless_cubemap_per_texture;
/*      */   public final boolean GL_AMD_shader_stencil_export;
/*      */   public final boolean GL_AMD_shader_trinary_minmax;
/*      */   public final boolean GL_AMD_sparse_texture;
/*      */   public final boolean GL_AMD_stencil_operation_extended;
/*      */   public final boolean GL_AMD_texture_texture4;
/*      */   public final boolean GL_AMD_transform_feedback3_lines_triangles;
/*      */   public final boolean GL_AMD_vertex_shader_layer;
/*      */   public final boolean GL_AMD_vertex_shader_tessellator;
/*      */   public final boolean GL_AMD_vertex_shader_viewport_index;
/*      */   public final boolean GL_APPLE_aux_depth_stencil;
/*      */   public final boolean GL_APPLE_client_storage;
/*      */   public final boolean GL_APPLE_element_array;
/*      */   public final boolean GL_APPLE_fence;
/*      */   public final boolean GL_APPLE_float_pixels;
/*      */   public final boolean GL_APPLE_flush_buffer_range;
/*      */   public final boolean GL_APPLE_object_purgeable;
/*      */   public final boolean GL_APPLE_packed_pixels;
/*      */   public final boolean GL_APPLE_rgb_422;
/*      */   public final boolean GL_APPLE_row_bytes;
/*      */   public final boolean GL_APPLE_texture_range;
/*      */   public final boolean GL_APPLE_vertex_array_object;
/*      */   public final boolean GL_APPLE_vertex_array_range;
/*      */   public final boolean GL_APPLE_vertex_program_evaluators;
/*      */   public final boolean GL_APPLE_ycbcr_422;
/*      */   public final boolean GL_ARB_ES2_compatibility;
/*      */   public final boolean GL_ARB_ES3_compatibility;
/*      */   public final boolean GL_ARB_arrays_of_arrays;
/*      */   public final boolean GL_ARB_base_instance;
/*      */   public final boolean GL_ARB_blend_func_extended;
/*      */   public final boolean GL_ARB_cl_event;
/*      */   public final boolean GL_ARB_clear_buffer_object;
/*      */   public final boolean GL_ARB_color_buffer_float;
/*      */   public final boolean GL_ARB_compatibility;
/*      */   public final boolean GL_ARB_compressed_texture_pixel_storage;
/*      */   public final boolean GL_ARB_compute_shader;
/*      */   public final boolean GL_ARB_conservative_depth;
/*      */   public final boolean GL_ARB_copy_buffer;
/*      */   public final boolean GL_ARB_copy_image;
/*      */   public final boolean GL_ARB_debug_output;
/*      */   public final boolean GL_ARB_depth_buffer_float;
/*      */   public final boolean GL_ARB_depth_clamp;
/*      */   public final boolean GL_ARB_depth_texture;
/*      */   public final boolean GL_ARB_draw_buffers;
/*      */   public final boolean GL_ARB_draw_buffers_blend;
/*      */   public final boolean GL_ARB_draw_elements_base_vertex;
/*      */   public final boolean GL_ARB_draw_indirect;
/*      */   public final boolean GL_ARB_draw_instanced;
/*      */   public final boolean GL_ARB_explicit_attrib_location;
/*      */   public final boolean GL_ARB_explicit_uniform_location;
/*      */   public final boolean GL_ARB_fragment_coord_conventions;
/*      */   public final boolean GL_ARB_fragment_layer_viewport;
/*      */   public final boolean GL_ARB_fragment_program;
/*      */   public final boolean GL_ARB_fragment_program_shadow;
/*      */   public final boolean GL_ARB_fragment_shader;
/*      */   public final boolean GL_ARB_framebuffer_no_attachments;
/*      */   public final boolean GL_ARB_framebuffer_object;
/*      */   public final boolean GL_ARB_framebuffer_sRGB;
/*      */   public final boolean GL_ARB_geometry_shader4;
/*      */   public final boolean GL_ARB_get_program_binary;
/*      */   public final boolean GL_ARB_gpu_shader5;
/*      */   public final boolean GL_ARB_gpu_shader_fp64;
/*      */   public final boolean GL_ARB_half_float_pixel;
/*      */   public final boolean GL_ARB_half_float_vertex;
/*      */   public final boolean GL_ARB_imaging;
/*      */   public final boolean GL_ARB_instanced_arrays;
/*      */   public final boolean GL_ARB_internalformat_query;
/*      */   public final boolean GL_ARB_internalformat_query2;
/*      */   public final boolean GL_ARB_invalidate_subdata;
/*      */   public final boolean GL_ARB_map_buffer_alignment;
/*      */   public final boolean GL_ARB_map_buffer_range;
/*      */   public final boolean GL_ARB_matrix_palette;
/*      */   public final boolean GL_ARB_multi_draw_indirect;
/*      */   public final boolean GL_ARB_multisample;
/*      */   public final boolean GL_ARB_multitexture;
/*      */   public final boolean GL_ARB_occlusion_query;
/*      */   public final boolean GL_ARB_occlusion_query2;
/*      */   public final boolean GL_ARB_pixel_buffer_object;
/*      */   public final boolean GL_ARB_point_parameters;
/*      */   public final boolean GL_ARB_point_sprite;
/*      */   public final boolean GL_ARB_program_interface_query;
/*      */   public final boolean GL_ARB_provoking_vertex;
/*      */   public final boolean GL_ARB_robust_buffer_access_behavior;
/*      */   public final boolean GL_ARB_robustness;
/*      */   public final boolean GL_ARB_robustness_isolation;
/*      */   public final boolean GL_ARB_sample_shading;
/*      */   public final boolean GL_ARB_sampler_objects;
/*      */   public final boolean GL_ARB_seamless_cube_map;
/*      */   public final boolean GL_ARB_separate_shader_objects;
/*      */   public final boolean GL_ARB_shader_atomic_counters;
/*      */   public final boolean GL_ARB_shader_bit_encoding;
/*      */   public final boolean GL_ARB_shader_image_load_store;
/*      */   public final boolean GL_ARB_shader_image_size;
/*      */   public final boolean GL_ARB_shader_objects;
/*      */   public final boolean GL_ARB_shader_precision;
/*      */   public final boolean GL_ARB_shader_stencil_export;
/*      */   public final boolean GL_ARB_shader_storage_buffer_object;
/*      */   public final boolean GL_ARB_shader_subroutine;
/*      */   public final boolean GL_ARB_shader_texture_lod;
/*      */   public final boolean GL_ARB_shading_language_100;
/*      */   public final boolean GL_ARB_shading_language_420pack;
/*      */   public final boolean GL_ARB_shading_language_include;
/*      */   public final boolean GL_ARB_shading_language_packing;
/*      */   public final boolean GL_ARB_shadow;
/*      */   public final boolean GL_ARB_shadow_ambient;
/*      */   public final boolean GL_ARB_stencil_texturing;
/*      */   public final boolean GL_ARB_sync;
/*      */   public final boolean GL_ARB_tessellation_shader;
/*      */   public final boolean GL_ARB_texture_border_clamp;
/*      */   public final boolean GL_ARB_texture_buffer_object;
/*      */   public final boolean GL_ARB_texture_buffer_object_rgb32;
/*      */   public final boolean GL_ARB_texture_buffer_range;
/*      */   public final boolean GL_ARB_texture_compression;
/*      */   public final boolean GL_ARB_texture_compression_bptc;
/*      */   public final boolean GL_ARB_texture_compression_rgtc;
/*      */   public final boolean GL_ARB_texture_cube_map;
/*      */   public final boolean GL_ARB_texture_cube_map_array;
/*      */   public final boolean GL_ARB_texture_env_add;
/*      */   public final boolean GL_ARB_texture_env_combine;
/*      */   public final boolean GL_ARB_texture_env_crossbar;
/*      */   public final boolean GL_ARB_texture_env_dot3;
/*      */   public final boolean GL_ARB_texture_float;
/*      */   public final boolean GL_ARB_texture_gather;
/*      */   public final boolean GL_ARB_texture_mirrored_repeat;
/*      */   public final boolean GL_ARB_texture_multisample;
/*      */   public final boolean GL_ARB_texture_non_power_of_two;
/*      */   public final boolean GL_ARB_texture_query_levels;
/*      */   public final boolean GL_ARB_texture_query_lod;
/*      */   public final boolean GL_ARB_texture_rectangle;
/*      */   public final boolean GL_ARB_texture_rg;
/*      */   public final boolean GL_ARB_texture_rgb10_a2ui;
/*      */   public final boolean GL_ARB_texture_storage;
/*      */   public final boolean GL_ARB_texture_storage_multisample;
/*      */   public final boolean GL_ARB_texture_swizzle;
/*      */   public final boolean GL_ARB_texture_view;
/*      */   public final boolean GL_ARB_timer_query;
/*      */   public final boolean GL_ARB_transform_feedback2;
/*      */   public final boolean GL_ARB_transform_feedback3;
/*      */   public final boolean GL_ARB_transform_feedback_instanced;
/*      */   public final boolean GL_ARB_transpose_matrix;
/*      */   public final boolean GL_ARB_uniform_buffer_object;
/*      */   public final boolean GL_ARB_vertex_array_bgra;
/*      */   public final boolean GL_ARB_vertex_array_object;
/*      */   public final boolean GL_ARB_vertex_attrib_64bit;
/*      */   public final boolean GL_ARB_vertex_attrib_binding;
/*      */   public final boolean GL_ARB_vertex_blend;
/*      */   public final boolean GL_ARB_vertex_buffer_object;
/*      */   public final boolean GL_ARB_vertex_program;
/*      */   public final boolean GL_ARB_vertex_shader;
/*      */   public final boolean GL_ARB_vertex_type_2_10_10_10_rev;
/*      */   public final boolean GL_ARB_viewport_array;
/*      */   public final boolean GL_ARB_window_pos;
/*      */   public final boolean GL_ATI_draw_buffers;
/*      */   public final boolean GL_ATI_element_array;
/*      */   public final boolean GL_ATI_envmap_bumpmap;
/*      */   public final boolean GL_ATI_fragment_shader;
/*      */   public final boolean GL_ATI_map_object_buffer;
/*      */   public final boolean GL_ATI_meminfo;
/*      */   public final boolean GL_ATI_pn_triangles;
/*      */   public final boolean GL_ATI_separate_stencil;
/*      */   public final boolean GL_ATI_shader_texture_lod;
/*      */   public final boolean GL_ATI_text_fragment_shader;
/*      */   public final boolean GL_ATI_texture_compression_3dc;
/*      */   public final boolean GL_ATI_texture_env_combine3;
/*      */   public final boolean GL_ATI_texture_float;
/*      */   public final boolean GL_ATI_texture_mirror_once;
/*      */   public final boolean GL_ATI_vertex_array_object;
/*      */   public final boolean GL_ATI_vertex_attrib_array_object;
/*      */   public final boolean GL_ATI_vertex_streams;
/*      */   public final boolean GL_EXT_abgr;
/*      */   public final boolean GL_EXT_bgra;
/*      */   public final boolean GL_EXT_bindable_uniform;
/*      */   public final boolean GL_EXT_blend_color;
/*      */   public final boolean GL_EXT_blend_equation_separate;
/*      */   public final boolean GL_EXT_blend_func_separate;
/*      */   public final boolean GL_EXT_blend_minmax;
/*      */   public final boolean GL_EXT_blend_subtract;
/*      */   public final boolean GL_EXT_Cg_shader;
/*      */   public final boolean GL_EXT_compiled_vertex_array;
/*      */   public final boolean GL_EXT_depth_bounds_test;
/*      */   public final boolean GL_EXT_direct_state_access;
/*      */   public final boolean GL_EXT_draw_buffers2;
/*      */   public final boolean GL_EXT_draw_instanced;
/*      */   public final boolean GL_EXT_draw_range_elements;
/*      */   public final boolean GL_EXT_fog_coord;
/*      */   public final boolean GL_EXT_framebuffer_blit;
/*      */   public final boolean GL_EXT_framebuffer_multisample;
/*      */   public final boolean GL_EXT_framebuffer_multisample_blit_scaled;
/*      */   public final boolean GL_EXT_framebuffer_object;
/*      */   public final boolean GL_EXT_framebuffer_sRGB;
/*      */   public final boolean GL_EXT_geometry_shader4;
/*      */   public final boolean GL_EXT_gpu_program_parameters;
/*      */   public final boolean GL_EXT_gpu_shader4;
/*      */   public final boolean GL_EXT_multi_draw_arrays;
/*      */   public final boolean GL_EXT_packed_depth_stencil;
/*      */   public final boolean GL_EXT_packed_float;
/*      */   public final boolean GL_EXT_packed_pixels;
/*      */   public final boolean GL_EXT_paletted_texture;
/*      */   public final boolean GL_EXT_pixel_buffer_object;
/*      */   public final boolean GL_EXT_point_parameters;
/*      */   public final boolean GL_EXT_provoking_vertex;
/*      */   public final boolean GL_EXT_rescale_normal;
/*      */   public final boolean GL_EXT_secondary_color;
/*      */   public final boolean GL_EXT_separate_shader_objects;
/*      */   public final boolean GL_EXT_separate_specular_color;
/*      */   public final boolean GL_EXT_shader_image_load_store;
/*      */   public final boolean GL_EXT_shadow_funcs;
/*      */   public final boolean GL_EXT_shared_texture_palette;
/*      */   public final boolean GL_EXT_stencil_clear_tag;
/*      */   public final boolean GL_EXT_stencil_two_side;
/*      */   public final boolean GL_EXT_stencil_wrap;
/*      */   public final boolean GL_EXT_texture_3d;
/*      */   public final boolean GL_EXT_texture_array;
/*      */   public final boolean GL_EXT_texture_buffer_object;
/*      */   public final boolean GL_EXT_texture_compression_latc;
/*      */   public final boolean GL_EXT_texture_compression_rgtc;
/*      */   public final boolean GL_EXT_texture_compression_s3tc;
/*      */   public final boolean GL_EXT_texture_env_combine;
/*      */   public final boolean GL_EXT_texture_env_dot3;
/*      */   public final boolean GL_EXT_texture_filter_anisotropic;
/*      */   public final boolean GL_EXT_texture_integer;
/*      */   public final boolean GL_EXT_texture_lod_bias;
/*      */   public final boolean GL_EXT_texture_mirror_clamp;
/*      */   public final boolean GL_EXT_texture_rectangle;
/*      */   public final boolean GL_EXT_texture_sRGB;
/*      */   public final boolean GL_EXT_texture_sRGB_decode;
/*      */   public final boolean GL_EXT_texture_shared_exponent;
/*      */   public final boolean GL_EXT_texture_snorm;
/*      */   public final boolean GL_EXT_texture_swizzle;
/*      */   public final boolean GL_EXT_timer_query;
/*      */   public final boolean GL_EXT_transform_feedback;
/*      */   public final boolean GL_EXT_vertex_array_bgra;
/*      */   public final boolean GL_EXT_vertex_attrib_64bit;
/*      */   public final boolean GL_EXT_vertex_shader;
/*      */   public final boolean GL_EXT_vertex_weighting;
/*      */   public final boolean OpenGL11;
/*      */   public final boolean OpenGL12;
/*      */   public final boolean OpenGL13;
/*      */   public final boolean OpenGL14;
/*      */   public final boolean OpenGL15;
/*      */   public final boolean OpenGL20;
/*      */   public final boolean OpenGL21;
/*      */   public final boolean OpenGL30;
/*      */   public final boolean OpenGL31;
/*      */   public final boolean OpenGL32;
/*      */   public final boolean OpenGL33;
/*      */   public final boolean OpenGL40;
/*      */   public final boolean OpenGL41;
/*      */   public final boolean OpenGL42;
/*      */   public final boolean OpenGL43;
/*      */   public final boolean GL_GREMEDY_frame_terminator;
/*      */   public final boolean GL_GREMEDY_string_marker;
/*      */   public final boolean GL_HP_occlusion_test;
/*      */   public final boolean GL_IBM_rasterpos_clip;
/*      */   public final boolean GL_INTEL_map_texture;
/*      */   public final boolean GL_KHR_debug;
/*      */   public final boolean GL_KHR_texture_compression_astc_ldr;
/*      */   public final boolean GL_NVX_gpu_memory_info;
/*      */   public final boolean GL_NV_bindless_texture;
/*      */   public final boolean GL_NV_blend_square;
/*      */   public final boolean GL_NV_compute_program5;
/*      */   public final boolean GL_NV_conditional_render;
/*      */   public final boolean GL_NV_copy_depth_to_color;
/*      */   public final boolean GL_NV_copy_image;
/*      */   public final boolean GL_NV_deep_texture3D;
/*      */   public final boolean GL_NV_depth_buffer_float;
/*      */   public final boolean GL_NV_depth_clamp;
/*      */   public final boolean GL_NV_draw_texture;
/*      */   public final boolean GL_NV_evaluators;
/*      */   public final boolean GL_NV_explicit_multisample;
/*      */   public final boolean GL_NV_fence;
/*      */   public final boolean GL_NV_float_buffer;
/*      */   public final boolean GL_NV_fog_distance;
/*      */   public final boolean GL_NV_fragment_program;
/*      */   public final boolean GL_NV_fragment_program2;
/*      */   public final boolean GL_NV_fragment_program4;
/*      */   public final boolean GL_NV_fragment_program_option;
/*      */   public final boolean GL_NV_framebuffer_multisample_coverage;
/*      */   public final boolean GL_NV_geometry_program4;
/*      */   public final boolean GL_NV_geometry_shader4;
/*      */   public final boolean GL_NV_gpu_program4;
/*      */   public final boolean GL_NV_gpu_program5;
/*      */   public final boolean GL_NV_gpu_shader5;
/*      */   public final boolean GL_NV_half_float;
/*      */   public final boolean GL_NV_light_max_exponent;
/*      */   public final boolean GL_NV_multisample_coverage;
/*      */   public final boolean GL_NV_multisample_filter_hint;
/*      */   public final boolean GL_NV_occlusion_query;
/*      */   public final boolean GL_NV_packed_depth_stencil;
/*      */   public final boolean GL_NV_parameter_buffer_object;
/*      */   public final boolean GL_NV_parameter_buffer_object2;
/*      */   public final boolean GL_NV_path_rendering;
/*      */   public final boolean GL_NV_pixel_data_range;
/*      */   public final boolean GL_NV_point_sprite;
/*      */   public final boolean GL_NV_present_video;
/*      */   public final boolean GL_NV_primitive_restart;
/*      */   public final boolean GL_NV_register_combiners;
/*      */   public final boolean GL_NV_register_combiners2;
/*      */   public final boolean GL_NV_shader_atomic_counters;
/*      */   public final boolean GL_NV_shader_atomic_float;
/*      */   public final boolean GL_NV_shader_buffer_load;
/*      */   public final boolean GL_NV_shader_buffer_store;
/*      */   public final boolean GL_NV_shader_storage_buffer_object;
/*      */   public final boolean GL_NV_tessellation_program5;
/*      */   public final boolean GL_NV_texgen_reflection;
/*      */   public final boolean GL_NV_texture_barrier;
/*      */   public final boolean GL_NV_texture_compression_vtc;
/*      */   public final boolean GL_NV_texture_env_combine4;
/*      */   public final boolean GL_NV_texture_expand_normal;
/*      */   public final boolean GL_NV_texture_multisample;
/*      */   public final boolean GL_NV_texture_rectangle;
/*      */   public final boolean GL_NV_texture_shader;
/*      */   public final boolean GL_NV_texture_shader2;
/*      */   public final boolean GL_NV_texture_shader3;
/*      */   public final boolean GL_NV_transform_feedback;
/*      */   public final boolean GL_NV_transform_feedback2;
/*      */   public final boolean GL_NV_vertex_array_range;
/*      */   public final boolean GL_NV_vertex_array_range2;
/*      */   public final boolean GL_NV_vertex_attrib_integer_64bit;
/*      */   public final boolean GL_NV_vertex_buffer_unified_memory;
/*      */   public final boolean GL_NV_vertex_program;
/*      */   public final boolean GL_NV_vertex_program1_1;
/*      */   public final boolean GL_NV_vertex_program2;
/*      */   public final boolean GL_NV_vertex_program2_option;
/*      */   public final boolean GL_NV_vertex_program3;
/*      */   public final boolean GL_NV_vertex_program4;
/*      */   public final boolean GL_NV_video_capture;
/*      */   public final boolean GL_SGIS_generate_mipmap;
/*      */   public final boolean GL_SGIS_texture_lod;
/*      */   public final boolean GL_SUN_slice_accum;
/*      */   long glDebugMessageEnableAMD;
/*      */   long glDebugMessageInsertAMD;
/*      */   long glDebugMessageCallbackAMD;
/*      */   long glGetDebugMessageLogAMD;
/*      */   long glBlendFuncIndexedAMD;
/*      */   long glBlendFuncSeparateIndexedAMD;
/*      */   long glBlendEquationIndexedAMD;
/*      */   long glBlendEquationSeparateIndexedAMD;
/*      */   long glMultiDrawArraysIndirectAMD;
/*      */   long glMultiDrawElementsIndirectAMD;
/*      */   long glGenNamesAMD;
/*      */   long glDeleteNamesAMD;
/*      */   long glIsNameAMD;
/*      */   long glGetPerfMonitorGroupsAMD;
/*      */   long glGetPerfMonitorCountersAMD;
/*      */   long glGetPerfMonitorGroupStringAMD;
/*      */   long glGetPerfMonitorCounterStringAMD;
/*      */   long glGetPerfMonitorCounterInfoAMD;
/*      */   long glGenPerfMonitorsAMD;
/*      */   long glDeletePerfMonitorsAMD;
/*      */   long glSelectPerfMonitorCountersAMD;
/*      */   long glBeginPerfMonitorAMD;
/*      */   long glEndPerfMonitorAMD;
/*      */   long glGetPerfMonitorCounterDataAMD;
/*      */   long glSetMultisamplefvAMD;
/*      */   long glTexStorageSparseAMD;
/*      */   long glTextureStorageSparseAMD;
/*      */   long glStencilOpValueAMD;
/*      */   long glTessellationFactorAMD;
/*      */   long glTessellationModeAMD;
/*      */   long glElementPointerAPPLE;
/*      */   long glDrawElementArrayAPPLE;
/*      */   long glDrawRangeElementArrayAPPLE;
/*      */   long glMultiDrawElementArrayAPPLE;
/*      */   long glMultiDrawRangeElementArrayAPPLE;
/*      */   long glGenFencesAPPLE;
/*      */   long glDeleteFencesAPPLE;
/*      */   long glSetFenceAPPLE;
/*      */   long glIsFenceAPPLE;
/*      */   long glTestFenceAPPLE;
/*      */   long glFinishFenceAPPLE;
/*      */   long glTestObjectAPPLE;
/*      */   long glFinishObjectAPPLE;
/*      */   long glBufferParameteriAPPLE;
/*      */   long glFlushMappedBufferRangeAPPLE;
/*      */   long glObjectPurgeableAPPLE;
/*      */   long glObjectUnpurgeableAPPLE;
/*      */   long glGetObjectParameterivAPPLE;
/*      */   long glTextureRangeAPPLE;
/*      */   long glGetTexParameterPointervAPPLE;
/*      */   long glBindVertexArrayAPPLE;
/*      */   long glDeleteVertexArraysAPPLE;
/*      */   long glGenVertexArraysAPPLE;
/*      */   long glIsVertexArrayAPPLE;
/*      */   long glVertexArrayRangeAPPLE;
/*      */   long glFlushVertexArrayRangeAPPLE;
/*      */   long glVertexArrayParameteriAPPLE;
/*      */   long glEnableVertexAttribAPPLE;
/*      */   long glDisableVertexAttribAPPLE;
/*      */   long glIsVertexAttribEnabledAPPLE;
/*      */   long glMapVertexAttrib1dAPPLE;
/*      */   long glMapVertexAttrib1fAPPLE;
/*      */   long glMapVertexAttrib2dAPPLE;
/*      */   long glMapVertexAttrib2fAPPLE;
/*      */   long glBindBufferARB;
/*      */   long glDeleteBuffersARB;
/*      */   long glGenBuffersARB;
/*      */   long glIsBufferARB;
/*      */   long glBufferDataARB;
/*      */   long glBufferSubDataARB;
/*      */   long glGetBufferSubDataARB;
/*      */   long glMapBufferARB;
/*      */   long glUnmapBufferARB;
/*      */   long glGetBufferParameterivARB;
/*      */   long glGetBufferPointervARB;
/*      */   long glCreateSyncFromCLeventARB;
/*      */   long glClearNamedBufferDataEXT;
/*      */   long glClearNamedBufferSubDataEXT;
/*      */   long glClampColorARB;
/*      */   long glDebugMessageControlARB;
/*      */   long glDebugMessageInsertARB;
/*      */   long glDebugMessageCallbackARB;
/*      */   long glGetDebugMessageLogARB;
/*      */   long glDrawBuffersARB;
/*      */   long glBlendEquationiARB;
/*      */   long glBlendEquationSeparateiARB;
/*      */   long glBlendFunciARB;
/*      */   long glBlendFuncSeparateiARB;
/*      */   long glDrawArraysInstancedARB;
/*      */   long glDrawElementsInstancedARB;
/*      */   long glNamedFramebufferParameteriEXT;
/*      */   long glGetNamedFramebufferParameterivEXT;
/*      */   long glProgramParameteriARB;
/*      */   long glFramebufferTextureARB;
/*      */   long glFramebufferTextureLayerARB;
/*      */   long glFramebufferTextureFaceARB;
/*      */   long glProgramUniform1dEXT;
/*      */   long glProgramUniform2dEXT;
/*      */   long glProgramUniform3dEXT;
/*      */   long glProgramUniform4dEXT;
/*      */   long glProgramUniform1dvEXT;
/*      */   long glProgramUniform2dvEXT;
/*      */   long glProgramUniform3dvEXT;
/*      */   long glProgramUniform4dvEXT;
/*      */   long glProgramUniformMatrix2dvEXT;
/*      */   long glProgramUniformMatrix3dvEXT;
/*      */   long glProgramUniformMatrix4dvEXT;
/*      */   long glProgramUniformMatrix2x3dvEXT;
/*      */   long glProgramUniformMatrix2x4dvEXT;
/*      */   long glProgramUniformMatrix3x2dvEXT;
/*      */   long glProgramUniformMatrix3x4dvEXT;
/*      */   long glProgramUniformMatrix4x2dvEXT;
/*      */   long glProgramUniformMatrix4x3dvEXT;
/*      */   long glColorTable;
/*      */   long glColorSubTable;
/*      */   long glColorTableParameteriv;
/*      */   long glColorTableParameterfv;
/*      */   long glCopyColorSubTable;
/*      */   long glCopyColorTable;
/*      */   long glGetColorTable;
/*      */   long glGetColorTableParameteriv;
/*      */   long glGetColorTableParameterfv;
/*      */   long glHistogram;
/*      */   long glResetHistogram;
/*      */   long glGetHistogram;
/*      */   long glGetHistogramParameterfv;
/*      */   long glGetHistogramParameteriv;
/*      */   long glMinmax;
/*      */   long glResetMinmax;
/*      */   long glGetMinmax;
/*      */   long glGetMinmaxParameterfv;
/*      */   long glGetMinmaxParameteriv;
/*      */   long glConvolutionFilter1D;
/*      */   long glConvolutionFilter2D;
/*      */   long glConvolutionParameterf;
/*      */   long glConvolutionParameterfv;
/*      */   long glConvolutionParameteri;
/*      */   long glConvolutionParameteriv;
/*      */   long glCopyConvolutionFilter1D;
/*      */   long glCopyConvolutionFilter2D;
/*      */   long glGetConvolutionFilter;
/*      */   long glGetConvolutionParameterfv;
/*      */   long glGetConvolutionParameteriv;
/*      */   long glSeparableFilter2D;
/*      */   long glGetSeparableFilter;
/*      */   long glVertexAttribDivisorARB;
/*      */   long glCurrentPaletteMatrixARB;
/*      */   long glMatrixIndexPointerARB;
/*      */   long glMatrixIndexubvARB;
/*      */   long glMatrixIndexusvARB;
/*      */   long glMatrixIndexuivARB;
/*      */   long glSampleCoverageARB;
/*      */   long glClientActiveTextureARB;
/*      */   long glActiveTextureARB;
/*      */   long glMultiTexCoord1fARB;
/*      */   long glMultiTexCoord1dARB;
/*      */   long glMultiTexCoord1iARB;
/*      */   long glMultiTexCoord1sARB;
/*      */   long glMultiTexCoord2fARB;
/*      */   long glMultiTexCoord2dARB;
/*      */   long glMultiTexCoord2iARB;
/*      */   long glMultiTexCoord2sARB;
/*      */   long glMultiTexCoord3fARB;
/*      */   long glMultiTexCoord3dARB;
/*      */   long glMultiTexCoord3iARB;
/*      */   long glMultiTexCoord3sARB;
/*      */   long glMultiTexCoord4fARB;
/*      */   long glMultiTexCoord4dARB;
/*      */   long glMultiTexCoord4iARB;
/*      */   long glMultiTexCoord4sARB;
/*      */   long glGenQueriesARB;
/*      */   long glDeleteQueriesARB;
/*      */   long glIsQueryARB;
/*      */   long glBeginQueryARB;
/*      */   long glEndQueryARB;
/*      */   long glGetQueryivARB;
/*      */   long glGetQueryObjectivARB;
/*      */   long glGetQueryObjectuivARB;
/*      */   long glPointParameterfARB;
/*      */   long glPointParameterfvARB;
/*      */   long glProgramStringARB;
/*      */   long glBindProgramARB;
/*      */   long glDeleteProgramsARB;
/*      */   long glGenProgramsARB;
/*      */   long glProgramEnvParameter4fARB;
/*      */   long glProgramEnvParameter4dARB;
/*      */   long glProgramEnvParameter4fvARB;
/*      */   long glProgramEnvParameter4dvARB;
/*      */   long glProgramLocalParameter4fARB;
/*      */   long glProgramLocalParameter4dARB;
/*      */   long glProgramLocalParameter4fvARB;
/*      */   long glProgramLocalParameter4dvARB;
/*      */   long glGetProgramEnvParameterfvARB;
/*      */   long glGetProgramEnvParameterdvARB;
/*      */   long glGetProgramLocalParameterfvARB;
/*      */   long glGetProgramLocalParameterdvARB;
/*      */   long glGetProgramivARB;
/*      */   long glGetProgramStringARB;
/*      */   long glIsProgramARB;
/*      */   long glGetGraphicsResetStatusARB;
/*      */   long glGetnMapdvARB;
/*      */   long glGetnMapfvARB;
/*      */   long glGetnMapivARB;
/*      */   long glGetnPixelMapfvARB;
/*      */   long glGetnPixelMapuivARB;
/*      */   long glGetnPixelMapusvARB;
/*      */   long glGetnPolygonStippleARB;
/*      */   long glGetnTexImageARB;
/*      */   long glReadnPixelsARB;
/*      */   long glGetnColorTableARB;
/*      */   long glGetnConvolutionFilterARB;
/*      */   long glGetnSeparableFilterARB;
/*      */   long glGetnHistogramARB;
/*      */   long glGetnMinmaxARB;
/*      */   long glGetnCompressedTexImageARB;
/*      */   long glGetnUniformfvARB;
/*      */   long glGetnUniformivARB;
/*      */   long glGetnUniformuivARB;
/*      */   long glGetnUniformdvARB;
/*      */   long glMinSampleShadingARB;
/*      */   long glDeleteObjectARB;
/*      */   long glGetHandleARB;
/*      */   long glDetachObjectARB;
/*      */   long glCreateShaderObjectARB;
/*      */   long glShaderSourceARB;
/*      */   long glCompileShaderARB;
/*      */   long glCreateProgramObjectARB;
/*      */   long glAttachObjectARB;
/*      */   long glLinkProgramARB;
/*      */   long glUseProgramObjectARB;
/*      */   long glValidateProgramARB;
/*      */   long glUniform1fARB;
/*      */   long glUniform2fARB;
/*      */   long glUniform3fARB;
/*      */   long glUniform4fARB;
/*      */   long glUniform1iARB;
/*      */   long glUniform2iARB;
/*      */   long glUniform3iARB;
/*      */   long glUniform4iARB;
/*      */   long glUniform1fvARB;
/*      */   long glUniform2fvARB;
/*      */   long glUniform3fvARB;
/*      */   long glUniform4fvARB;
/*      */   long glUniform1ivARB;
/*      */   long glUniform2ivARB;
/*      */   long glUniform3ivARB;
/*      */   long glUniform4ivARB;
/*      */   long glUniformMatrix2fvARB;
/*      */   long glUniformMatrix3fvARB;
/*      */   long glUniformMatrix4fvARB;
/*      */   long glGetObjectParameterfvARB;
/*      */   long glGetObjectParameterivARB;
/*      */   long glGetInfoLogARB;
/*      */   long glGetAttachedObjectsARB;
/*      */   long glGetUniformLocationARB;
/*      */   long glGetActiveUniformARB;
/*      */   long glGetUniformfvARB;
/*      */   long glGetUniformivARB;
/*      */   long glGetShaderSourceARB;
/*      */   long glNamedStringARB;
/*      */   long glDeleteNamedStringARB;
/*      */   long glCompileShaderIncludeARB;
/*      */   long glIsNamedStringARB;
/*      */   long glGetNamedStringARB;
/*      */   long glGetNamedStringivARB;
/*      */   long glTexBufferARB;
/*      */   long glTextureBufferRangeEXT;
/*      */   long glCompressedTexImage1DARB;
/*      */   long glCompressedTexImage2DARB;
/*      */   long glCompressedTexImage3DARB;
/*      */   long glCompressedTexSubImage1DARB;
/*      */   long glCompressedTexSubImage2DARB;
/*      */   long glCompressedTexSubImage3DARB;
/*      */   long glGetCompressedTexImageARB;
/*      */   long glTextureStorage1DEXT;
/*      */   long glTextureStorage2DEXT;
/*      */   long glTextureStorage3DEXT;
/*      */   long glTextureStorage2DMultisampleEXT;
/*      */   long glTextureStorage3DMultisampleEXT;
/*      */   long glLoadTransposeMatrixfARB;
/*      */   long glMultTransposeMatrixfARB;
/*      */   long glVertexArrayVertexAttribLOffsetEXT;
/*      */   long glWeightbvARB;
/*      */   long glWeightsvARB;
/*      */   long glWeightivARB;
/*      */   long glWeightfvARB;
/*      */   long glWeightdvARB;
/*      */   long glWeightubvARB;
/*      */   long glWeightusvARB;
/*      */   long glWeightuivARB;
/*      */   long glWeightPointerARB;
/*      */   long glVertexBlendARB;
/*      */   long glVertexAttrib1sARB;
/*      */   long glVertexAttrib1fARB;
/*      */   long glVertexAttrib1dARB;
/*      */   long glVertexAttrib2sARB;
/*      */   long glVertexAttrib2fARB;
/*      */   long glVertexAttrib2dARB;
/*      */   long glVertexAttrib3sARB;
/*      */   long glVertexAttrib3fARB;
/*      */   long glVertexAttrib3dARB;
/*      */   long glVertexAttrib4sARB;
/*      */   long glVertexAttrib4fARB;
/*      */   long glVertexAttrib4dARB;
/*      */   long glVertexAttrib4NubARB;
/*      */   long glVertexAttribPointerARB;
/*      */   long glEnableVertexAttribArrayARB;
/*      */   long glDisableVertexAttribArrayARB;
/*      */   long glBindAttribLocationARB;
/*      */   long glGetActiveAttribARB;
/*      */   long glGetAttribLocationARB;
/*      */   long glGetVertexAttribfvARB;
/*      */   long glGetVertexAttribdvARB;
/*      */   long glGetVertexAttribivARB;
/*      */   long glGetVertexAttribPointervARB;
/*      */   long glWindowPos2fARB;
/*      */   long glWindowPos2dARB;
/*      */   long glWindowPos2iARB;
/*      */   long glWindowPos2sARB;
/*      */   long glWindowPos3fARB;
/*      */   long glWindowPos3dARB;
/*      */   long glWindowPos3iARB;
/*      */   long glWindowPos3sARB;
/*      */   long glDrawBuffersATI;
/*      */   long glElementPointerATI;
/*      */   long glDrawElementArrayATI;
/*      */   long glDrawRangeElementArrayATI;
/*      */   long glTexBumpParameterfvATI;
/*      */   long glTexBumpParameterivATI;
/*      */   long glGetTexBumpParameterfvATI;
/*      */   long glGetTexBumpParameterivATI;
/*      */   long glGenFragmentShadersATI;
/*      */   long glBindFragmentShaderATI;
/*      */   long glDeleteFragmentShaderATI;
/*      */   long glBeginFragmentShaderATI;
/*      */   long glEndFragmentShaderATI;
/*      */   long glPassTexCoordATI;
/*      */   long glSampleMapATI;
/*      */   long glColorFragmentOp1ATI;
/*      */   long glColorFragmentOp2ATI;
/*      */   long glColorFragmentOp3ATI;
/*      */   long glAlphaFragmentOp1ATI;
/*      */   long glAlphaFragmentOp2ATI;
/*      */   long glAlphaFragmentOp3ATI;
/*      */   long glSetFragmentShaderConstantATI;
/*      */   long glMapObjectBufferATI;
/*      */   long glUnmapObjectBufferATI;
/*      */   long glPNTrianglesfATI;
/*      */   long glPNTrianglesiATI;
/*      */   long glStencilOpSeparateATI;
/*      */   long glStencilFuncSeparateATI;
/*      */   long glNewObjectBufferATI;
/*      */   long glIsObjectBufferATI;
/*      */   long glUpdateObjectBufferATI;
/*      */   long glGetObjectBufferfvATI;
/*      */   long glGetObjectBufferivATI;
/*      */   long glFreeObjectBufferATI;
/*      */   long glArrayObjectATI;
/*      */   long glGetArrayObjectfvATI;
/*      */   long glGetArrayObjectivATI;
/*      */   long glVariantArrayObjectATI;
/*      */   long glGetVariantArrayObjectfvATI;
/*      */   long glGetVariantArrayObjectivATI;
/*      */   long glVertexAttribArrayObjectATI;
/*      */   long glGetVertexAttribArrayObjectfvATI;
/*      */   long glGetVertexAttribArrayObjectivATI;
/*      */   long glVertexStream2fATI;
/*      */   long glVertexStream2dATI;
/*      */   long glVertexStream2iATI;
/*      */   long glVertexStream2sATI;
/*      */   long glVertexStream3fATI;
/*      */   long glVertexStream3dATI;
/*      */   long glVertexStream3iATI;
/*      */   long glVertexStream3sATI;
/*      */   long glVertexStream4fATI;
/*      */   long glVertexStream4dATI;
/*      */   long glVertexStream4iATI;
/*      */   long glVertexStream4sATI;
/*      */   long glNormalStream3bATI;
/*      */   long glNormalStream3fATI;
/*      */   long glNormalStream3dATI;
/*      */   long glNormalStream3iATI;
/*      */   long glNormalStream3sATI;
/*      */   long glClientActiveVertexStreamATI;
/*      */   long glVertexBlendEnvfATI;
/*      */   long glVertexBlendEnviATI;
/*      */   long glUniformBufferEXT;
/*      */   long glGetUniformBufferSizeEXT;
/*      */   long glGetUniformOffsetEXT;
/*      */   long glBlendColorEXT;
/*      */   long glBlendEquationSeparateEXT;
/*      */   long glBlendFuncSeparateEXT;
/*      */   long glBlendEquationEXT;
/*      */   long glLockArraysEXT;
/*      */   long glUnlockArraysEXT;
/*      */   long glDepthBoundsEXT;
/*      */   long glClientAttribDefaultEXT;
/*      */   long glPushClientAttribDefaultEXT;
/*      */   long glMatrixLoadfEXT;
/*      */   long glMatrixLoaddEXT;
/*      */   long glMatrixMultfEXT;
/*      */   long glMatrixMultdEXT;
/*      */   long glMatrixLoadIdentityEXT;
/*      */   long glMatrixRotatefEXT;
/*      */   long glMatrixRotatedEXT;
/*      */   long glMatrixScalefEXT;
/*      */   long glMatrixScaledEXT;
/*      */   long glMatrixTranslatefEXT;
/*      */   long glMatrixTranslatedEXT;
/*      */   long glMatrixOrthoEXT;
/*      */   long glMatrixFrustumEXT;
/*      */   long glMatrixPushEXT;
/*      */   long glMatrixPopEXT;
/*      */   long glTextureParameteriEXT;
/*      */   long glTextureParameterivEXT;
/*      */   long glTextureParameterfEXT;
/*      */   long glTextureParameterfvEXT;
/*      */   long glTextureImage1DEXT;
/*      */   long glTextureImage2DEXT;
/*      */   long glTextureSubImage1DEXT;
/*      */   long glTextureSubImage2DEXT;
/*      */   long glCopyTextureImage1DEXT;
/*      */   long glCopyTextureImage2DEXT;
/*      */   long glCopyTextureSubImage1DEXT;
/*      */   long glCopyTextureSubImage2DEXT;
/*      */   long glGetTextureImageEXT;
/*      */   long glGetTextureParameterfvEXT;
/*      */   long glGetTextureParameterivEXT;
/*      */   long glGetTextureLevelParameterfvEXT;
/*      */   long glGetTextureLevelParameterivEXT;
/*      */   long glTextureImage3DEXT;
/*      */   long glTextureSubImage3DEXT;
/*      */   long glCopyTextureSubImage3DEXT;
/*      */   long glBindMultiTextureEXT;
/*      */   long glMultiTexCoordPointerEXT;
/*      */   long glMultiTexEnvfEXT;
/*      */   long glMultiTexEnvfvEXT;
/*      */   long glMultiTexEnviEXT;
/*      */   long glMultiTexEnvivEXT;
/*      */   long glMultiTexGendEXT;
/*      */   long glMultiTexGendvEXT;
/*      */   long glMultiTexGenfEXT;
/*      */   long glMultiTexGenfvEXT;
/*      */   long glMultiTexGeniEXT;
/*      */   long glMultiTexGenivEXT;
/*      */   long glGetMultiTexEnvfvEXT;
/*      */   long glGetMultiTexEnvivEXT;
/*      */   long glGetMultiTexGendvEXT;
/*      */   long glGetMultiTexGenfvEXT;
/*      */   long glGetMultiTexGenivEXT;
/*      */   long glMultiTexParameteriEXT;
/*      */   long glMultiTexParameterivEXT;
/*      */   long glMultiTexParameterfEXT;
/*      */   long glMultiTexParameterfvEXT;
/*      */   long glMultiTexImage1DEXT;
/*      */   long glMultiTexImage2DEXT;
/*      */   long glMultiTexSubImage1DEXT;
/*      */   long glMultiTexSubImage2DEXT;
/*      */   long glCopyMultiTexImage1DEXT;
/*      */   long glCopyMultiTexImage2DEXT;
/*      */   long glCopyMultiTexSubImage1DEXT;
/*      */   long glCopyMultiTexSubImage2DEXT;
/*      */   long glGetMultiTexImageEXT;
/*      */   long glGetMultiTexParameterfvEXT;
/*      */   long glGetMultiTexParameterivEXT;
/*      */   long glGetMultiTexLevelParameterfvEXT;
/*      */   long glGetMultiTexLevelParameterivEXT;
/*      */   long glMultiTexImage3DEXT;
/*      */   long glMultiTexSubImage3DEXT;
/*      */   long glCopyMultiTexSubImage3DEXT;
/*      */   long glEnableClientStateIndexedEXT;
/*      */   long glDisableClientStateIndexedEXT;
/*      */   long glEnableClientStateiEXT;
/*      */   long glDisableClientStateiEXT;
/*      */   long glGetFloatIndexedvEXT;
/*      */   long glGetDoubleIndexedvEXT;
/*      */   long glGetPointerIndexedvEXT;
/*      */   long glGetFloati_vEXT;
/*      */   long glGetDoublei_vEXT;
/*      */   long glGetPointeri_vEXT;
/*      */   long glNamedProgramStringEXT;
/*      */   long glNamedProgramLocalParameter4dEXT;
/*      */   long glNamedProgramLocalParameter4dvEXT;
/*      */   long glNamedProgramLocalParameter4fEXT;
/*      */   long glNamedProgramLocalParameter4fvEXT;
/*      */   long glGetNamedProgramLocalParameterdvEXT;
/*      */   long glGetNamedProgramLocalParameterfvEXT;
/*      */   long glGetNamedProgramivEXT;
/*      */   long glGetNamedProgramStringEXT;
/*      */   long glCompressedTextureImage3DEXT;
/*      */   long glCompressedTextureImage2DEXT;
/*      */   long glCompressedTextureImage1DEXT;
/*      */   long glCompressedTextureSubImage3DEXT;
/*      */   long glCompressedTextureSubImage2DEXT;
/*      */   long glCompressedTextureSubImage1DEXT;
/*      */   long glGetCompressedTextureImageEXT;
/*      */   long glCompressedMultiTexImage3DEXT;
/*      */   long glCompressedMultiTexImage2DEXT;
/*      */   long glCompressedMultiTexImage1DEXT;
/*      */   long glCompressedMultiTexSubImage3DEXT;
/*      */   long glCompressedMultiTexSubImage2DEXT;
/*      */   long glCompressedMultiTexSubImage1DEXT;
/*      */   long glGetCompressedMultiTexImageEXT;
/*      */   long glMatrixLoadTransposefEXT;
/*      */   long glMatrixLoadTransposedEXT;
/*      */   long glMatrixMultTransposefEXT;
/*      */   long glMatrixMultTransposedEXT;
/*      */   long glNamedBufferDataEXT;
/*      */   long glNamedBufferSubDataEXT;
/*      */   long glMapNamedBufferEXT;
/*      */   long glUnmapNamedBufferEXT;
/*      */   long glGetNamedBufferParameterivEXT;
/*      */   long glGetNamedBufferPointervEXT;
/*      */   long glGetNamedBufferSubDataEXT;
/*      */   long glProgramUniform1fEXT;
/*      */   long glProgramUniform2fEXT;
/*      */   long glProgramUniform3fEXT;
/*      */   long glProgramUniform4fEXT;
/*      */   long glProgramUniform1iEXT;
/*      */   long glProgramUniform2iEXT;
/*      */   long glProgramUniform3iEXT;
/*      */   long glProgramUniform4iEXT;
/*      */   long glProgramUniform1fvEXT;
/*      */   long glProgramUniform2fvEXT;
/*      */   long glProgramUniform3fvEXT;
/*      */   long glProgramUniform4fvEXT;
/*      */   long glProgramUniform1ivEXT;
/*      */   long glProgramUniform2ivEXT;
/*      */   long glProgramUniform3ivEXT;
/*      */   long glProgramUniform4ivEXT;
/*      */   long glProgramUniformMatrix2fvEXT;
/*      */   long glProgramUniformMatrix3fvEXT;
/*      */   long glProgramUniformMatrix4fvEXT;
/*      */   long glProgramUniformMatrix2x3fvEXT;
/*      */   long glProgramUniformMatrix3x2fvEXT;
/*      */   long glProgramUniformMatrix2x4fvEXT;
/*      */   long glProgramUniformMatrix4x2fvEXT;
/*      */   long glProgramUniformMatrix3x4fvEXT;
/*      */   long glProgramUniformMatrix4x3fvEXT;
/*      */   long glTextureBufferEXT;
/*      */   long glMultiTexBufferEXT;
/*      */   long glTextureParameterIivEXT;
/*      */   long glTextureParameterIuivEXT;
/*      */   long glGetTextureParameterIivEXT;
/*      */   long glGetTextureParameterIuivEXT;
/*      */   long glMultiTexParameterIivEXT;
/*      */   long glMultiTexParameterIuivEXT;
/*      */   long glGetMultiTexParameterIivEXT;
/*      */   long glGetMultiTexParameterIuivEXT;
/*      */   long glProgramUniform1uiEXT;
/*      */   long glProgramUniform2uiEXT;
/*      */   long glProgramUniform3uiEXT;
/*      */   long glProgramUniform4uiEXT;
/*      */   long glProgramUniform1uivEXT;
/*      */   long glProgramUniform2uivEXT;
/*      */   long glProgramUniform3uivEXT;
/*      */   long glProgramUniform4uivEXT;
/*      */   long glNamedProgramLocalParameters4fvEXT;
/*      */   long glNamedProgramLocalParameterI4iEXT;
/*      */   long glNamedProgramLocalParameterI4ivEXT;
/*      */   long glNamedProgramLocalParametersI4ivEXT;
/*      */   long glNamedProgramLocalParameterI4uiEXT;
/*      */   long glNamedProgramLocalParameterI4uivEXT;
/*      */   long glNamedProgramLocalParametersI4uivEXT;
/*      */   long glGetNamedProgramLocalParameterIivEXT;
/*      */   long glGetNamedProgramLocalParameterIuivEXT;
/*      */   long glNamedRenderbufferStorageEXT;
/*      */   long glGetNamedRenderbufferParameterivEXT;
/*      */   long glNamedRenderbufferStorageMultisampleEXT;
/*      */   long glNamedRenderbufferStorageMultisampleCoverageEXT;
/*      */   long glCheckNamedFramebufferStatusEXT;
/*      */   long glNamedFramebufferTexture1DEXT;
/*      */   long glNamedFramebufferTexture2DEXT;
/*      */   long glNamedFramebufferTexture3DEXT;
/*      */   long glNamedFramebufferRenderbufferEXT;
/*      */   long glGetNamedFramebufferAttachmentParameterivEXT;
/*      */   long glGenerateTextureMipmapEXT;
/*      */   long glGenerateMultiTexMipmapEXT;
/*      */   long glFramebufferDrawBufferEXT;
/*      */   long glFramebufferDrawBuffersEXT;
/*      */   long glFramebufferReadBufferEXT;
/*      */   long glGetFramebufferParameterivEXT;
/*      */   long glNamedCopyBufferSubDataEXT;
/*      */   long glNamedFramebufferTextureEXT;
/*      */   long glNamedFramebufferTextureLayerEXT;
/*      */   long glNamedFramebufferTextureFaceEXT;
/*      */   long glTextureRenderbufferEXT;
/*      */   long glMultiTexRenderbufferEXT;
/*      */   long glVertexArrayVertexOffsetEXT;
/*      */   long glVertexArrayColorOffsetEXT;
/*      */   long glVertexArrayEdgeFlagOffsetEXT;
/*      */   long glVertexArrayIndexOffsetEXT;
/*      */   long glVertexArrayNormalOffsetEXT;
/*      */   long glVertexArrayTexCoordOffsetEXT;
/*      */   long glVertexArrayMultiTexCoordOffsetEXT;
/*      */   long glVertexArrayFogCoordOffsetEXT;
/*      */   long glVertexArraySecondaryColorOffsetEXT;
/*      */   long glVertexArrayVertexAttribOffsetEXT;
/*      */   long glVertexArrayVertexAttribIOffsetEXT;
/*      */   long glEnableVertexArrayEXT;
/*      */   long glDisableVertexArrayEXT;
/*      */   long glEnableVertexArrayAttribEXT;
/*      */   long glDisableVertexArrayAttribEXT;
/*      */   long glGetVertexArrayIntegervEXT;
/*      */   long glGetVertexArrayPointervEXT;
/*      */   long glGetVertexArrayIntegeri_vEXT;
/*      */   long glGetVertexArrayPointeri_vEXT;
/*      */   long glMapNamedBufferRangeEXT;
/*      */   long glFlushMappedNamedBufferRangeEXT;
/*      */   long glColorMaskIndexedEXT;
/*      */   long glGetBooleanIndexedvEXT;
/*      */   long glGetIntegerIndexedvEXT;
/*      */   long glEnableIndexedEXT;
/*      */   long glDisableIndexedEXT;
/*      */   long glIsEnabledIndexedEXT;
/*      */   long glDrawArraysInstancedEXT;
/*      */   long glDrawElementsInstancedEXT;
/*      */   long glDrawRangeElementsEXT;
/*      */   long glFogCoordfEXT;
/*      */   long glFogCoorddEXT;
/*      */   long glFogCoordPointerEXT;
/*      */   long glBlitFramebufferEXT;
/*      */   long glRenderbufferStorageMultisampleEXT;
/*      */   long glIsRenderbufferEXT;
/*      */   long glBindRenderbufferEXT;
/*      */   long glDeleteRenderbuffersEXT;
/*      */   long glGenRenderbuffersEXT;
/*      */   long glRenderbufferStorageEXT;
/*      */   long glGetRenderbufferParameterivEXT;
/*      */   long glIsFramebufferEXT;
/*      */   long glBindFramebufferEXT;
/*      */   long glDeleteFramebuffersEXT;
/*      */   long glGenFramebuffersEXT;
/*      */   long glCheckFramebufferStatusEXT;
/*      */   long glFramebufferTexture1DEXT;
/*      */   long glFramebufferTexture2DEXT;
/*      */   long glFramebufferTexture3DEXT;
/*      */   long glFramebufferRenderbufferEXT;
/*      */   long glGetFramebufferAttachmentParameterivEXT;
/*      */   long glGenerateMipmapEXT;
/*      */   long glProgramParameteriEXT;
/*      */   long glFramebufferTextureEXT;
/*      */   long glFramebufferTextureLayerEXT;
/*      */   long glFramebufferTextureFaceEXT;
/*      */   long glProgramEnvParameters4fvEXT;
/*      */   long glProgramLocalParameters4fvEXT;
/*      */   long glVertexAttribI1iEXT;
/*      */   long glVertexAttribI2iEXT;
/*      */   long glVertexAttribI3iEXT;
/*      */   long glVertexAttribI4iEXT;
/*      */   long glVertexAttribI1uiEXT;
/*      */   long glVertexAttribI2uiEXT;
/*      */   long glVertexAttribI3uiEXT;
/*      */   long glVertexAttribI4uiEXT;
/*      */   long glVertexAttribI1ivEXT;
/*      */   long glVertexAttribI2ivEXT;
/*      */   long glVertexAttribI3ivEXT;
/*      */   long glVertexAttribI4ivEXT;
/*      */   long glVertexAttribI1uivEXT;
/*      */   long glVertexAttribI2uivEXT;
/*      */   long glVertexAttribI3uivEXT;
/*      */   long glVertexAttribI4uivEXT;
/*      */   long glVertexAttribI4bvEXT;
/*      */   long glVertexAttribI4svEXT;
/*      */   long glVertexAttribI4ubvEXT;
/*      */   long glVertexAttribI4usvEXT;
/*      */   long glVertexAttribIPointerEXT;
/*      */   long glGetVertexAttribIivEXT;
/*      */   long glGetVertexAttribIuivEXT;
/*      */   long glUniform1uiEXT;
/*      */   long glUniform2uiEXT;
/*      */   long glUniform3uiEXT;
/*      */   long glUniform4uiEXT;
/*      */   long glUniform1uivEXT;
/*      */   long glUniform2uivEXT;
/*      */   long glUniform3uivEXT;
/*      */   long glUniform4uivEXT;
/*      */   long glGetUniformuivEXT;
/*      */   long glBindFragDataLocationEXT;
/*      */   long glGetFragDataLocationEXT;
/*      */   long glMultiDrawArraysEXT;
/*      */   long glColorTableEXT;
/*      */   long glColorSubTableEXT;
/*      */   long glGetColorTableEXT;
/*      */   long glGetColorTableParameterivEXT;
/*      */   long glGetColorTableParameterfvEXT;
/*      */   long glPointParameterfEXT;
/*      */   long glPointParameterfvEXT;
/*      */   long glProvokingVertexEXT;
/*      */   long glSecondaryColor3bEXT;
/*      */   long glSecondaryColor3fEXT;
/*      */   long glSecondaryColor3dEXT;
/*      */   long glSecondaryColor3ubEXT;
/*      */   long glSecondaryColorPointerEXT;
/*      */   long glUseShaderProgramEXT;
/*      */   long glActiveProgramEXT;
/*      */   long glCreateShaderProgramEXT;
/*      */   long glBindImageTextureEXT;
/*      */   long glMemoryBarrierEXT;
/*      */   long glStencilClearTagEXT;
/*      */   long glActiveStencilFaceEXT;
/*      */   long glTexBufferEXT;
/*      */   long glClearColorIiEXT;
/*      */   long glClearColorIuiEXT;
/*      */   long glTexParameterIivEXT;
/*      */   long glTexParameterIuivEXT;
/*      */   long glGetTexParameterIivEXT;
/*      */   long glGetTexParameterIuivEXT;
/*      */   long glGetQueryObjecti64vEXT;
/*      */   long glGetQueryObjectui64vEXT;
/*      */   long glBindBufferRangeEXT;
/*      */   long glBindBufferOffsetEXT;
/*      */   long glBindBufferBaseEXT;
/*      */   long glBeginTransformFeedbackEXT;
/*      */   long glEndTransformFeedbackEXT;
/*      */   long glTransformFeedbackVaryingsEXT;
/*      */   long glGetTransformFeedbackVaryingEXT;
/*      */   long glVertexAttribL1dEXT;
/*      */   long glVertexAttribL2dEXT;
/*      */   long glVertexAttribL3dEXT;
/*      */   long glVertexAttribL4dEXT;
/*      */   long glVertexAttribL1dvEXT;
/*      */   long glVertexAttribL2dvEXT;
/*      */   long glVertexAttribL3dvEXT;
/*      */   long glVertexAttribL4dvEXT;
/*      */   long glVertexAttribLPointerEXT;
/*      */   long glGetVertexAttribLdvEXT;
/*      */   long glBeginVertexShaderEXT;
/*      */   long glEndVertexShaderEXT;
/*      */   long glBindVertexShaderEXT;
/*      */   long glGenVertexShadersEXT;
/*      */   long glDeleteVertexShaderEXT;
/*      */   long glShaderOp1EXT;
/*      */   long glShaderOp2EXT;
/*      */   long glShaderOp3EXT;
/*      */   long glSwizzleEXT;
/*      */   long glWriteMaskEXT;
/*      */   long glInsertComponentEXT;
/*      */   long glExtractComponentEXT;
/*      */   long glGenSymbolsEXT;
/*      */   long glSetInvariantEXT;
/*      */   long glSetLocalConstantEXT;
/*      */   long glVariantbvEXT;
/*      */   long glVariantsvEXT;
/*      */   long glVariantivEXT;
/*      */   long glVariantfvEXT;
/*      */   long glVariantdvEXT;
/*      */   long glVariantubvEXT;
/*      */   long glVariantusvEXT;
/*      */   long glVariantuivEXT;
/*      */   long glVariantPointerEXT;
/*      */   long glEnableVariantClientStateEXT;
/*      */   long glDisableVariantClientStateEXT;
/*      */   long glBindLightParameterEXT;
/*      */   long glBindMaterialParameterEXT;
/*      */   long glBindTexGenParameterEXT;
/*      */   long glBindTextureUnitParameterEXT;
/*      */   long glBindParameterEXT;
/*      */   long glIsVariantEnabledEXT;
/*      */   long glGetVariantBooleanvEXT;
/*      */   long glGetVariantIntegervEXT;
/*      */   long glGetVariantFloatvEXT;
/*      */   long glGetVariantPointervEXT;
/*      */   long glGetInvariantBooleanvEXT;
/*      */   long glGetInvariantIntegervEXT;
/*      */   long glGetInvariantFloatvEXT;
/*      */   long glGetLocalConstantBooleanvEXT;
/*      */   long glGetLocalConstantIntegervEXT;
/*      */   long glGetLocalConstantFloatvEXT;
/*      */   long glVertexWeightfEXT;
/*      */   long glVertexWeightPointerEXT;
/*      */   long glAccum;
/*      */   long glAlphaFunc;
/*      */   long glClearColor;
/*      */   long glClearAccum;
/*      */   long glClear;
/*      */   long glCallLists;
/*      */   long glCallList;
/*      */   long glBlendFunc;
/*      */   long glBitmap;
/*      */   long glBindTexture;
/*      */   long glPrioritizeTextures;
/*      */   long glAreTexturesResident;
/*      */   long glBegin;
/*      */   long glEnd;
/*      */   long glArrayElement;
/*      */   long glClearDepth;
/*      */   long glDeleteLists;
/*      */   long glDeleteTextures;
/*      */   long glCullFace;
/*      */   long glCopyTexSubImage2D;
/*      */   long glCopyTexSubImage1D;
/*      */   long glCopyTexImage2D;
/*      */   long glCopyTexImage1D;
/*      */   long glCopyPixels;
/*      */   long glColorPointer;
/*      */   long glColorMaterial;
/*      */   long glColorMask;
/*      */   long glColor3b;
/*      */   long glColor3f;
/*      */   long glColor3d;
/*      */   long glColor3ub;
/*      */   long glColor4b;
/*      */   long glColor4f;
/*      */   long glColor4d;
/*      */   long glColor4ub;
/*      */   long glClipPlane;
/*      */   long glClearStencil;
/*      */   long glEvalPoint1;
/*      */   long glEvalPoint2;
/*      */   long glEvalMesh1;
/*      */   long glEvalMesh2;
/*      */   long glEvalCoord1f;
/*      */   long glEvalCoord1d;
/*      */   long glEvalCoord2f;
/*      */   long glEvalCoord2d;
/*      */   long glEnableClientState;
/*      */   long glDisableClientState;
/*      */   long glEnable;
/*      */   long glDisable;
/*      */   long glEdgeFlagPointer;
/*      */   long glEdgeFlag;
/*      */   long glDrawPixels;
/*      */   long glDrawElements;
/*      */   long glDrawBuffer;
/*      */   long glDrawArrays;
/*      */   long glDepthRange;
/*      */   long glDepthMask;
/*      */   long glDepthFunc;
/*      */   long glFeedbackBuffer;
/*      */   long glGetPixelMapfv;
/*      */   long glGetPixelMapuiv;
/*      */   long glGetPixelMapusv;
/*      */   long glGetMaterialfv;
/*      */   long glGetMaterialiv;
/*      */   long glGetMapfv;
/*      */   long glGetMapdv;
/*      */   long glGetMapiv;
/*      */   long glGetLightfv;
/*      */   long glGetLightiv;
/*      */   long glGetError;
/*      */   long glGetClipPlane;
/*      */   long glGetBooleanv;
/*      */   long glGetDoublev;
/*      */   long glGetFloatv;
/*      */   long glGetIntegerv;
/*      */   long glGenTextures;
/*      */   long glGenLists;
/*      */   long glFrustum;
/*      */   long glFrontFace;
/*      */   long glFogf;
/*      */   long glFogi;
/*      */   long glFogfv;
/*      */   long glFogiv;
/*      */   long glFlush;
/*      */   long glFinish;
/*      */   long glGetPointerv;
/*      */   long glIsEnabled;
/*      */   long glInterleavedArrays;
/*      */   long glInitNames;
/*      */   long glHint;
/*      */   long glGetTexParameterfv;
/*      */   long glGetTexParameteriv;
/*      */   long glGetTexLevelParameterfv;
/*      */   long glGetTexLevelParameteriv;
/*      */   long glGetTexImage;
/*      */   long glGetTexGeniv;
/*      */   long glGetTexGenfv;
/*      */   long glGetTexGendv;
/*      */   long glGetTexEnviv;
/*      */   long glGetTexEnvfv;
/*      */   long glGetString;
/*      */   long glGetPolygonStipple;
/*      */   long glIsList;
/*      */   long glMaterialf;
/*      */   long glMateriali;
/*      */   long glMaterialfv;
/*      */   long glMaterialiv;
/*      */   long glMapGrid1f;
/*      */   long glMapGrid1d;
/*      */   long glMapGrid2f;
/*      */   long glMapGrid2d;
/*      */   long glMap2f;
/*      */   long glMap2d;
/*      */   long glMap1f;
/*      */   long glMap1d;
/*      */   long glLogicOp;
/*      */   long glLoadName;
/*      */   long glLoadMatrixf;
/*      */   long glLoadMatrixd;
/*      */   long glLoadIdentity;
/*      */   long glListBase;
/*      */   long glLineWidth;
/*      */   long glLineStipple;
/*      */   long glLightModelf;
/*      */   long glLightModeli;
/*      */   long glLightModelfv;
/*      */   long glLightModeliv;
/*      */   long glLightf;
/*      */   long glLighti;
/*      */   long glLightfv;
/*      */   long glLightiv;
/*      */   long glIsTexture;
/*      */   long glMatrixMode;
/*      */   long glPolygonStipple;
/*      */   long glPolygonOffset;
/*      */   long glPolygonMode;
/*      */   long glPointSize;
/*      */   long glPixelZoom;
/*      */   long glPixelTransferf;
/*      */   long glPixelTransferi;
/*      */   long glPixelStoref;
/*      */   long glPixelStorei;
/*      */   long glPixelMapfv;
/*      */   long glPixelMapuiv;
/*      */   long glPixelMapusv;
/*      */   long glPassThrough;
/*      */   long glOrtho;
/*      */   long glNormalPointer;
/*      */   long glNormal3b;
/*      */   long glNormal3f;
/*      */   long glNormal3d;
/*      */   long glNormal3i;
/*      */   long glNewList;
/*      */   long glEndList;
/*      */   long glMultMatrixf;
/*      */   long glMultMatrixd;
/*      */   long glShadeModel;
/*      */   long glSelectBuffer;
/*      */   long glScissor;
/*      */   long glScalef;
/*      */   long glScaled;
/*      */   long glRotatef;
/*      */   long glRotated;
/*      */   long glRenderMode;
/*      */   long glRectf;
/*      */   long glRectd;
/*      */   long glRecti;
/*      */   long glReadPixels;
/*      */   long glReadBuffer;
/*      */   long glRasterPos2f;
/*      */   long glRasterPos2d;
/*      */   long glRasterPos2i;
/*      */   long glRasterPos3f;
/*      */   long glRasterPos3d;
/*      */   long glRasterPos3i;
/*      */   long glRasterPos4f;
/*      */   long glRasterPos4d;
/*      */   long glRasterPos4i;
/*      */   long glPushName;
/*      */   long glPopName;
/*      */   long glPushMatrix;
/*      */   long glPopMatrix;
/*      */   long glPushClientAttrib;
/*      */   long glPopClientAttrib;
/*      */   long glPushAttrib;
/*      */   long glPopAttrib;
/*      */   long glStencilFunc;
/*      */   long glVertexPointer;
/*      */   long glVertex2f;
/*      */   long glVertex2d;
/*      */   long glVertex2i;
/*      */   long glVertex3f;
/*      */   long glVertex3d;
/*      */   long glVertex3i;
/*      */   long glVertex4f;
/*      */   long glVertex4d;
/*      */   long glVertex4i;
/*      */   long glTranslatef;
/*      */   long glTranslated;
/*      */   long glTexImage1D;
/*      */   long glTexImage2D;
/*      */   long glTexSubImage1D;
/*      */   long glTexSubImage2D;
/*      */   long glTexParameterf;
/*      */   long glTexParameteri;
/*      */   long glTexParameterfv;
/*      */   long glTexParameteriv;
/*      */   long glTexGenf;
/*      */   long glTexGend;
/*      */   long glTexGenfv;
/*      */   long glTexGendv;
/*      */   long glTexGeni;
/*      */   long glTexGeniv;
/*      */   long glTexEnvf;
/*      */   long glTexEnvi;
/*      */   long glTexEnvfv;
/*      */   long glTexEnviv;
/*      */   long glTexCoordPointer;
/*      */   long glTexCoord1f;
/*      */   long glTexCoord1d;
/*      */   long glTexCoord2f;
/*      */   long glTexCoord2d;
/*      */   long glTexCoord3f;
/*      */   long glTexCoord3d;
/*      */   long glTexCoord4f;
/*      */   long glTexCoord4d;
/*      */   long glStencilOp;
/*      */   long glStencilMask;
/*      */   long glViewport;
/*      */   long glDrawRangeElements;
/*      */   long glTexImage3D;
/*      */   long glTexSubImage3D;
/*      */   long glCopyTexSubImage3D;
/*      */   long glActiveTexture;
/*      */   long glClientActiveTexture;
/*      */   long glCompressedTexImage1D;
/*      */   long glCompressedTexImage2D;
/*      */   long glCompressedTexImage3D;
/*      */   long glCompressedTexSubImage1D;
/*      */   long glCompressedTexSubImage2D;
/*      */   long glCompressedTexSubImage3D;
/*      */   long glGetCompressedTexImage;
/*      */   long glMultiTexCoord1f;
/*      */   long glMultiTexCoord1d;
/*      */   long glMultiTexCoord2f;
/*      */   long glMultiTexCoord2d;
/*      */   long glMultiTexCoord3f;
/*      */   long glMultiTexCoord3d;
/*      */   long glMultiTexCoord4f;
/*      */   long glMultiTexCoord4d;
/*      */   long glLoadTransposeMatrixf;
/*      */   long glLoadTransposeMatrixd;
/*      */   long glMultTransposeMatrixf;
/*      */   long glMultTransposeMatrixd;
/*      */   long glSampleCoverage;
/*      */   long glBlendEquation;
/*      */   long glBlendColor;
/*      */   long glFogCoordf;
/*      */   long glFogCoordd;
/*      */   long glFogCoordPointer;
/*      */   long glMultiDrawArrays;
/*      */   long glPointParameteri;
/*      */   long glPointParameterf;
/*      */   long glPointParameteriv;
/*      */   long glPointParameterfv;
/*      */   long glSecondaryColor3b;
/*      */   long glSecondaryColor3f;
/*      */   long glSecondaryColor3d;
/*      */   long glSecondaryColor3ub;
/*      */   long glSecondaryColorPointer;
/*      */   long glBlendFuncSeparate;
/*      */   long glWindowPos2f;
/*      */   long glWindowPos2d;
/*      */   long glWindowPos2i;
/*      */   long glWindowPos3f;
/*      */   long glWindowPos3d;
/*      */   long glWindowPos3i;
/*      */   long glBindBuffer;
/*      */   long glDeleteBuffers;
/*      */   long glGenBuffers;
/*      */   long glIsBuffer;
/*      */   long glBufferData;
/*      */   long glBufferSubData;
/*      */   long glGetBufferSubData;
/*      */   long glMapBuffer;
/*      */   long glUnmapBuffer;
/*      */   long glGetBufferParameteriv;
/*      */   long glGetBufferPointerv;
/*      */   long glGenQueries;
/*      */   long glDeleteQueries;
/*      */   long glIsQuery;
/*      */   long glBeginQuery;
/*      */   long glEndQuery;
/*      */   long glGetQueryiv;
/*      */   long glGetQueryObjectiv;
/*      */   long glGetQueryObjectuiv;
/*      */   long glShaderSource;
/*      */   long glCreateShader;
/*      */   long glIsShader;
/*      */   long glCompileShader;
/*      */   long glDeleteShader;
/*      */   long glCreateProgram;
/*      */   long glIsProgram;
/*      */   long glAttachShader;
/*      */   long glDetachShader;
/*      */   long glLinkProgram;
/*      */   long glUseProgram;
/*      */   long glValidateProgram;
/*      */   long glDeleteProgram;
/*      */   long glUniform1f;
/*      */   long glUniform2f;
/*      */   long glUniform3f;
/*      */   long glUniform4f;
/*      */   long glUniform1i;
/*      */   long glUniform2i;
/*      */   long glUniform3i;
/*      */   long glUniform4i;
/*      */   long glUniform1fv;
/*      */   long glUniform2fv;
/*      */   long glUniform3fv;
/*      */   long glUniform4fv;
/*      */   long glUniform1iv;
/*      */   long glUniform2iv;
/*      */   long glUniform3iv;
/*      */   long glUniform4iv;
/*      */   long glUniformMatrix2fv;
/*      */   long glUniformMatrix3fv;
/*      */   long glUniformMatrix4fv;
/*      */   long glGetShaderiv;
/*      */   long glGetProgramiv;
/*      */   long glGetShaderInfoLog;
/*      */   long glGetProgramInfoLog;
/*      */   long glGetAttachedShaders;
/*      */   long glGetUniformLocation;
/*      */   long glGetActiveUniform;
/*      */   long glGetUniformfv;
/*      */   long glGetUniformiv;
/*      */   long glGetShaderSource;
/*      */   long glVertexAttrib1s;
/*      */   long glVertexAttrib1f;
/*      */   long glVertexAttrib1d;
/*      */   long glVertexAttrib2s;
/*      */   long glVertexAttrib2f;
/*      */   long glVertexAttrib2d;
/*      */   long glVertexAttrib3s;
/*      */   long glVertexAttrib3f;
/*      */   long glVertexAttrib3d;
/*      */   long glVertexAttrib4s;
/*      */   long glVertexAttrib4f;
/*      */   long glVertexAttrib4d;
/*      */   long glVertexAttrib4Nub;
/*      */   long glVertexAttribPointer;
/*      */   long glEnableVertexAttribArray;
/*      */   long glDisableVertexAttribArray;
/*      */   long glGetVertexAttribfv;
/*      */   long glGetVertexAttribdv;
/*      */   long glGetVertexAttribiv;
/*      */   long glGetVertexAttribPointerv;
/*      */   long glBindAttribLocation;
/*      */   long glGetActiveAttrib;
/*      */   long glGetAttribLocation;
/*      */   long glDrawBuffers;
/*      */   long glStencilOpSeparate;
/*      */   long glStencilFuncSeparate;
/*      */   long glStencilMaskSeparate;
/*      */   long glBlendEquationSeparate;
/*      */   long glUniformMatrix2x3fv;
/*      */   long glUniformMatrix3x2fv;
/*      */   long glUniformMatrix2x4fv;
/*      */   long glUniformMatrix4x2fv;
/*      */   long glUniformMatrix3x4fv;
/*      */   long glUniformMatrix4x3fv;
/*      */   long glGetStringi;
/*      */   long glClearBufferfv;
/*      */   long glClearBufferiv;
/*      */   long glClearBufferuiv;
/*      */   long glClearBufferfi;
/*      */   long glVertexAttribI1i;
/*      */   long glVertexAttribI2i;
/*      */   long glVertexAttribI3i;
/*      */   long glVertexAttribI4i;
/*      */   long glVertexAttribI1ui;
/*      */   long glVertexAttribI2ui;
/*      */   long glVertexAttribI3ui;
/*      */   long glVertexAttribI4ui;
/*      */   long glVertexAttribI1iv;
/*      */   long glVertexAttribI2iv;
/*      */   long glVertexAttribI3iv;
/*      */   long glVertexAttribI4iv;
/*      */   long glVertexAttribI1uiv;
/*      */   long glVertexAttribI2uiv;
/*      */   long glVertexAttribI3uiv;
/*      */   long glVertexAttribI4uiv;
/*      */   long glVertexAttribI4bv;
/*      */   long glVertexAttribI4sv;
/*      */   long glVertexAttribI4ubv;
/*      */   long glVertexAttribI4usv;
/*      */   long glVertexAttribIPointer;
/*      */   long glGetVertexAttribIiv;
/*      */   long glGetVertexAttribIuiv;
/*      */   long glUniform1ui;
/*      */   long glUniform2ui;
/*      */   long glUniform3ui;
/*      */   long glUniform4ui;
/*      */   long glUniform1uiv;
/*      */   long glUniform2uiv;
/*      */   long glUniform3uiv;
/*      */   long glUniform4uiv;
/*      */   long glGetUniformuiv;
/*      */   long glBindFragDataLocation;
/*      */   long glGetFragDataLocation;
/*      */   long glBeginConditionalRender;
/*      */   long glEndConditionalRender;
/*      */   long glMapBufferRange;
/*      */   long glFlushMappedBufferRange;
/*      */   long glClampColor;
/*      */   long glIsRenderbuffer;
/*      */   long glBindRenderbuffer;
/*      */   long glDeleteRenderbuffers;
/*      */   long glGenRenderbuffers;
/*      */   long glRenderbufferStorage;
/*      */   long glGetRenderbufferParameteriv;
/*      */   long glIsFramebuffer;
/*      */   long glBindFramebuffer;
/*      */   long glDeleteFramebuffers;
/*      */   long glGenFramebuffers;
/*      */   long glCheckFramebufferStatus;
/*      */   long glFramebufferTexture1D;
/*      */   long glFramebufferTexture2D;
/*      */   long glFramebufferTexture3D;
/*      */   long glFramebufferRenderbuffer;
/*      */   long glGetFramebufferAttachmentParameteriv;
/*      */   long glGenerateMipmap;
/*      */   long glRenderbufferStorageMultisample;
/*      */   long glBlitFramebuffer;
/*      */   long glTexParameterIiv;
/*      */   long glTexParameterIuiv;
/*      */   long glGetTexParameterIiv;
/*      */   long glGetTexParameterIuiv;
/*      */   long glFramebufferTextureLayer;
/*      */   long glColorMaski;
/*      */   long glGetBooleani_v;
/*      */   long glGetIntegeri_v;
/*      */   long glEnablei;
/*      */   long glDisablei;
/*      */   long glIsEnabledi;
/*      */   long glBindBufferRange;
/*      */   long glBindBufferBase;
/*      */   long glBeginTransformFeedback;
/*      */   long glEndTransformFeedback;
/*      */   long glTransformFeedbackVaryings;
/*      */   long glGetTransformFeedbackVarying;
/*      */   long glBindVertexArray;
/*      */   long glDeleteVertexArrays;
/*      */   long glGenVertexArrays;
/*      */   long glIsVertexArray;
/*      */   long glDrawArraysInstanced;
/*      */   long glDrawElementsInstanced;
/*      */   long glCopyBufferSubData;
/*      */   long glPrimitiveRestartIndex;
/*      */   long glTexBuffer;
/*      */   long glGetUniformIndices;
/*      */   long glGetActiveUniformsiv;
/*      */   long glGetActiveUniformName;
/*      */   long glGetUniformBlockIndex;
/*      */   long glGetActiveUniformBlockiv;
/*      */   long glGetActiveUniformBlockName;
/*      */   long glUniformBlockBinding;
/*      */   long glGetBufferParameteri64v;
/*      */   long glDrawElementsBaseVertex;
/*      */   long glDrawRangeElementsBaseVertex;
/*      */   long glDrawElementsInstancedBaseVertex;
/*      */   long glProvokingVertex;
/*      */   long glTexImage2DMultisample;
/*      */   long glTexImage3DMultisample;
/*      */   long glGetMultisamplefv;
/*      */   long glSampleMaski;
/*      */   long glFramebufferTexture;
/*      */   long glFenceSync;
/*      */   long glIsSync;
/*      */   long glDeleteSync;
/*      */   long glClientWaitSync;
/*      */   long glWaitSync;
/*      */   long glGetInteger64v;
/*      */   long glGetInteger64i_v;
/*      */   long glGetSynciv;
/*      */   long glBindFragDataLocationIndexed;
/*      */   long glGetFragDataIndex;
/*      */   long glGenSamplers;
/*      */   long glDeleteSamplers;
/*      */   long glIsSampler;
/*      */   long glBindSampler;
/*      */   long glSamplerParameteri;
/*      */   long glSamplerParameterf;
/*      */   long glSamplerParameteriv;
/*      */   long glSamplerParameterfv;
/*      */   long glSamplerParameterIiv;
/*      */   long glSamplerParameterIuiv;
/*      */   long glGetSamplerParameteriv;
/*      */   long glGetSamplerParameterfv;
/*      */   long glGetSamplerParameterIiv;
/*      */   long glGetSamplerParameterIuiv;
/*      */   long glQueryCounter;
/*      */   long glGetQueryObjecti64v;
/*      */   long glGetQueryObjectui64v;
/*      */   long glVertexAttribDivisor;
/*      */   long glVertexP2ui;
/*      */   long glVertexP3ui;
/*      */   long glVertexP4ui;
/*      */   long glVertexP2uiv;
/*      */   long glVertexP3uiv;
/*      */   long glVertexP4uiv;
/*      */   long glTexCoordP1ui;
/*      */   long glTexCoordP2ui;
/*      */   long glTexCoordP3ui;
/*      */   long glTexCoordP4ui;
/*      */   long glTexCoordP1uiv;
/*      */   long glTexCoordP2uiv;
/*      */   long glTexCoordP3uiv;
/*      */   long glTexCoordP4uiv;
/*      */   long glMultiTexCoordP1ui;
/*      */   long glMultiTexCoordP2ui;
/*      */   long glMultiTexCoordP3ui;
/*      */   long glMultiTexCoordP4ui;
/*      */   long glMultiTexCoordP1uiv;
/*      */   long glMultiTexCoordP2uiv;
/*      */   long glMultiTexCoordP3uiv;
/*      */   long glMultiTexCoordP4uiv;
/*      */   long glNormalP3ui;
/*      */   long glNormalP3uiv;
/*      */   long glColorP3ui;
/*      */   long glColorP4ui;
/*      */   long glColorP3uiv;
/*      */   long glColorP4uiv;
/*      */   long glSecondaryColorP3ui;
/*      */   long glSecondaryColorP3uiv;
/*      */   long glVertexAttribP1ui;
/*      */   long glVertexAttribP2ui;
/*      */   long glVertexAttribP3ui;
/*      */   long glVertexAttribP4ui;
/*      */   long glVertexAttribP1uiv;
/*      */   long glVertexAttribP2uiv;
/*      */   long glVertexAttribP3uiv;
/*      */   long glVertexAttribP4uiv;
/*      */   long glBlendEquationi;
/*      */   long glBlendEquationSeparatei;
/*      */   long glBlendFunci;
/*      */   long glBlendFuncSeparatei;
/*      */   long glDrawArraysIndirect;
/*      */   long glDrawElementsIndirect;
/*      */   long glUniform1d;
/*      */   long glUniform2d;
/*      */   long glUniform3d;
/*      */   long glUniform4d;
/*      */   long glUniform1dv;
/*      */   long glUniform2dv;
/*      */   long glUniform3dv;
/*      */   long glUniform4dv;
/*      */   long glUniformMatrix2dv;
/*      */   long glUniformMatrix3dv;
/*      */   long glUniformMatrix4dv;
/*      */   long glUniformMatrix2x3dv;
/*      */   long glUniformMatrix2x4dv;
/*      */   long glUniformMatrix3x2dv;
/*      */   long glUniformMatrix3x4dv;
/*      */   long glUniformMatrix4x2dv;
/*      */   long glUniformMatrix4x3dv;
/*      */   long glGetUniformdv;
/*      */   long glMinSampleShading;
/*      */   long glGetSubroutineUniformLocation;
/*      */   long glGetSubroutineIndex;
/*      */   long glGetActiveSubroutineUniformiv;
/*      */   long glGetActiveSubroutineUniformName;
/*      */   long glGetActiveSubroutineName;
/*      */   long glUniformSubroutinesuiv;
/*      */   long glGetUniformSubroutineuiv;
/*      */   long glGetProgramStageiv;
/*      */   long glPatchParameteri;
/*      */   long glPatchParameterfv;
/*      */   long glBindTransformFeedback;
/*      */   long glDeleteTransformFeedbacks;
/*      */   long glGenTransformFeedbacks;
/*      */   long glIsTransformFeedback;
/*      */   long glPauseTransformFeedback;
/*      */   long glResumeTransformFeedback;
/*      */   long glDrawTransformFeedback;
/*      */   long glDrawTransformFeedbackStream;
/*      */   long glBeginQueryIndexed;
/*      */   long glEndQueryIndexed;
/*      */   long glGetQueryIndexediv;
/*      */   long glReleaseShaderCompiler;
/*      */   long glShaderBinary;
/*      */   long glGetShaderPrecisionFormat;
/*      */   long glDepthRangef;
/*      */   long glClearDepthf;
/*      */   long glGetProgramBinary;
/*      */   long glProgramBinary;
/*      */   long glProgramParameteri;
/*      */   long glUseProgramStages;
/*      */   long glActiveShaderProgram;
/*      */   long glCreateShaderProgramv;
/*      */   long glBindProgramPipeline;
/*      */   long glDeleteProgramPipelines;
/*      */   long glGenProgramPipelines;
/*      */   long glIsProgramPipeline;
/*      */   long glGetProgramPipelineiv;
/*      */   long glProgramUniform1i;
/*      */   long glProgramUniform2i;
/*      */   long glProgramUniform3i;
/*      */   long glProgramUniform4i;
/*      */   long glProgramUniform1f;
/*      */   long glProgramUniform2f;
/*      */   long glProgramUniform3f;
/*      */   long glProgramUniform4f;
/*      */   long glProgramUniform1d;
/*      */   long glProgramUniform2d;
/*      */   long glProgramUniform3d;
/*      */   long glProgramUniform4d;
/*      */   long glProgramUniform1iv;
/*      */   long glProgramUniform2iv;
/*      */   long glProgramUniform3iv;
/*      */   long glProgramUniform4iv;
/*      */   long glProgramUniform1fv;
/*      */   long glProgramUniform2fv;
/*      */   long glProgramUniform3fv;
/*      */   long glProgramUniform4fv;
/*      */   long glProgramUniform1dv;
/*      */   long glProgramUniform2dv;
/*      */   long glProgramUniform3dv;
/*      */   long glProgramUniform4dv;
/*      */   long glProgramUniform1ui;
/*      */   long glProgramUniform2ui;
/*      */   long glProgramUniform3ui;
/*      */   long glProgramUniform4ui;
/*      */   long glProgramUniform1uiv;
/*      */   long glProgramUniform2uiv;
/*      */   long glProgramUniform3uiv;
/*      */   long glProgramUniform4uiv;
/*      */   long glProgramUniformMatrix2fv;
/*      */   long glProgramUniformMatrix3fv;
/*      */   long glProgramUniformMatrix4fv;
/*      */   long glProgramUniformMatrix2dv;
/*      */   long glProgramUniformMatrix3dv;
/*      */   long glProgramUniformMatrix4dv;
/*      */   long glProgramUniformMatrix2x3fv;
/*      */   long glProgramUniformMatrix3x2fv;
/*      */   long glProgramUniformMatrix2x4fv;
/*      */   long glProgramUniformMatrix4x2fv;
/*      */   long glProgramUniformMatrix3x4fv;
/*      */   long glProgramUniformMatrix4x3fv;
/*      */   long glProgramUniformMatrix2x3dv;
/*      */   long glProgramUniformMatrix3x2dv;
/*      */   long glProgramUniformMatrix2x4dv;
/*      */   long glProgramUniformMatrix4x2dv;
/*      */   long glProgramUniformMatrix3x4dv;
/*      */   long glProgramUniformMatrix4x3dv;
/*      */   long glValidateProgramPipeline;
/*      */   long glGetProgramPipelineInfoLog;
/*      */   long glVertexAttribL1d;
/*      */   long glVertexAttribL2d;
/*      */   long glVertexAttribL3d;
/*      */   long glVertexAttribL4d;
/*      */   long glVertexAttribL1dv;
/*      */   long glVertexAttribL2dv;
/*      */   long glVertexAttribL3dv;
/*      */   long glVertexAttribL4dv;
/*      */   long glVertexAttribLPointer;
/*      */   long glGetVertexAttribLdv;
/*      */   long glViewportArrayv;
/*      */   long glViewportIndexedf;
/*      */   long glViewportIndexedfv;
/*      */   long glScissorArrayv;
/*      */   long glScissorIndexed;
/*      */   long glScissorIndexedv;
/*      */   long glDepthRangeArrayv;
/*      */   long glDepthRangeIndexed;
/*      */   long glGetFloati_v;
/*      */   long glGetDoublei_v;
/*      */   long glGetActiveAtomicCounterBufferiv;
/*      */   long glTexStorage1D;
/*      */   long glTexStorage2D;
/*      */   long glTexStorage3D;
/*      */   long glDrawTransformFeedbackInstanced;
/*      */   long glDrawTransformFeedbackStreamInstanced;
/*      */   long glDrawArraysInstancedBaseInstance;
/*      */   long glDrawElementsInstancedBaseInstance;
/*      */   long glDrawElementsInstancedBaseVertexBaseInstance;
/*      */   long glBindImageTexture;
/*      */   long glMemoryBarrier;
/*      */   long glGetInternalformativ;
/*      */   long glClearBufferData;
/*      */   long glClearBufferSubData;
/*      */   long glDispatchCompute;
/*      */   long glDispatchComputeIndirect;
/*      */   long glCopyImageSubData;
/*      */   long glDebugMessageControl;
/*      */   long glDebugMessageInsert;
/*      */   long glDebugMessageCallback;
/*      */   long glGetDebugMessageLog;
/*      */   long glPushDebugGroup;
/*      */   long glPopDebugGroup;
/*      */   long glObjectLabel;
/*      */   long glGetObjectLabel;
/*      */   long glObjectPtrLabel;
/*      */   long glGetObjectPtrLabel;
/*      */   long glFramebufferParameteri;
/*      */   long glGetFramebufferParameteriv;
/*      */   long glGetInternalformati64v;
/*      */   long glInvalidateTexSubImage;
/*      */   long glInvalidateTexImage;
/*      */   long glInvalidateBufferSubData;
/*      */   long glInvalidateBufferData;
/*      */   long glInvalidateFramebuffer;
/*      */   long glInvalidateSubFramebuffer;
/*      */   long glMultiDrawArraysIndirect;
/*      */   long glMultiDrawElementsIndirect;
/*      */   long glGetProgramInterfaceiv;
/*      */   long glGetProgramResourceIndex;
/*      */   long glGetProgramResourceName;
/*      */   long glGetProgramResourceiv;
/*      */   long glGetProgramResourceLocation;
/*      */   long glGetProgramResourceLocationIndex;
/*      */   long glShaderStorageBlockBinding;
/*      */   long glTexBufferRange;
/*      */   long glTexStorage2DMultisample;
/*      */   long glTexStorage3DMultisample;
/*      */   long glTextureView;
/*      */   long glBindVertexBuffer;
/*      */   long glVertexAttribFormat;
/*      */   long glVertexAttribIFormat;
/*      */   long glVertexAttribLFormat;
/*      */   long glVertexAttribBinding;
/*      */   long glVertexBindingDivisor;
/*      */   long glFrameTerminatorGREMEDY;
/*      */   long glStringMarkerGREMEDY;
/*      */   long glMapTexture2DINTEL;
/*      */   long glUnmapTexture2DINTEL;
/*      */   long glSyncTextureINTEL;
/*      */   long glGetTextureHandleNV;
/*      */   long glGetTextureSamplerHandleNV;
/*      */   long glMakeTextureHandleResidentNV;
/*      */   long glMakeTextureHandleNonResidentNV;
/*      */   long glGetImageHandleNV;
/*      */   long glMakeImageHandleResidentNV;
/*      */   long glMakeImageHandleNonResidentNV;
/*      */   long glUniformHandleui64NV;
/*      */   long glUniformHandleui64vNV;
/*      */   long glProgramUniformHandleui64NV;
/*      */   long glProgramUniformHandleui64vNV;
/*      */   long glIsTextureHandleResidentNV;
/*      */   long glIsImageHandleResidentNV;
/*      */   long glBeginConditionalRenderNV;
/*      */   long glEndConditionalRenderNV;
/*      */   long glCopyImageSubDataNV;
/*      */   long glDepthRangedNV;
/*      */   long glClearDepthdNV;
/*      */   long glDepthBoundsdNV;
/*      */   long glDrawTextureNV;
/*      */   long glGetMapControlPointsNV;
/*      */   long glMapControlPointsNV;
/*      */   long glMapParameterfvNV;
/*      */   long glMapParameterivNV;
/*      */   long glGetMapParameterfvNV;
/*      */   long glGetMapParameterivNV;
/*      */   long glGetMapAttribParameterfvNV;
/*      */   long glGetMapAttribParameterivNV;
/*      */   long glEvalMapsNV;
/*      */   long glGetMultisamplefvNV;
/*      */   long glSampleMaskIndexedNV;
/*      */   long glTexRenderbufferNV;
/*      */   long glGenFencesNV;
/*      */   long glDeleteFencesNV;
/*      */   long glSetFenceNV;
/*      */   long glTestFenceNV;
/*      */   long glFinishFenceNV;
/*      */   long glIsFenceNV;
/*      */   long glGetFenceivNV;
/*      */   long glProgramNamedParameter4fNV;
/*      */   long glProgramNamedParameter4dNV;
/*      */   long glGetProgramNamedParameterfvNV;
/*      */   long glGetProgramNamedParameterdvNV;
/*      */   long glRenderbufferStorageMultisampleCoverageNV;
/*      */   long glProgramVertexLimitNV;
/*      */   long glProgramLocalParameterI4iNV;
/*      */   long glProgramLocalParameterI4ivNV;
/*      */   long glProgramLocalParametersI4ivNV;
/*      */   long glProgramLocalParameterI4uiNV;
/*      */   long glProgramLocalParameterI4uivNV;
/*      */   long glProgramLocalParametersI4uivNV;
/*      */   long glProgramEnvParameterI4iNV;
/*      */   long glProgramEnvParameterI4ivNV;
/*      */   long glProgramEnvParametersI4ivNV;
/*      */   long glProgramEnvParameterI4uiNV;
/*      */   long glProgramEnvParameterI4uivNV;
/*      */   long glProgramEnvParametersI4uivNV;
/*      */   long glGetProgramLocalParameterIivNV;
/*      */   long glGetProgramLocalParameterIuivNV;
/*      */   long glGetProgramEnvParameterIivNV;
/*      */   long glGetProgramEnvParameterIuivNV;
/*      */   long glUniform1i64NV;
/*      */   long glUniform2i64NV;
/*      */   long glUniform3i64NV;
/*      */   long glUniform4i64NV;
/*      */   long glUniform1i64vNV;
/*      */   long glUniform2i64vNV;
/*      */   long glUniform3i64vNV;
/*      */   long glUniform4i64vNV;
/*      */   long glUniform1ui64NV;
/*      */   long glUniform2ui64NV;
/*      */   long glUniform3ui64NV;
/*      */   long glUniform4ui64NV;
/*      */   long glUniform1ui64vNV;
/*      */   long glUniform2ui64vNV;
/*      */   long glUniform3ui64vNV;
/*      */   long glUniform4ui64vNV;
/*      */   long glGetUniformi64vNV;
/*      */   long glGetUniformui64vNV;
/*      */   long glProgramUniform1i64NV;
/*      */   long glProgramUniform2i64NV;
/*      */   long glProgramUniform3i64NV;
/*      */   long glProgramUniform4i64NV;
/*      */   long glProgramUniform1i64vNV;
/*      */   long glProgramUniform2i64vNV;
/*      */   long glProgramUniform3i64vNV;
/*      */   long glProgramUniform4i64vNV;
/*      */   long glProgramUniform1ui64NV;
/*      */   long glProgramUniform2ui64NV;
/*      */   long glProgramUniform3ui64NV;
/*      */   long glProgramUniform4ui64NV;
/*      */   long glProgramUniform1ui64vNV;
/*      */   long glProgramUniform2ui64vNV;
/*      */   long glProgramUniform3ui64vNV;
/*      */   long glProgramUniform4ui64vNV;
/*      */   long glVertex2hNV;
/*      */   long glVertex3hNV;
/*      */   long glVertex4hNV;
/*      */   long glNormal3hNV;
/*      */   long glColor3hNV;
/*      */   long glColor4hNV;
/*      */   long glTexCoord1hNV;
/*      */   long glTexCoord2hNV;
/*      */   long glTexCoord3hNV;
/*      */   long glTexCoord4hNV;
/*      */   long glMultiTexCoord1hNV;
/*      */   long glMultiTexCoord2hNV;
/*      */   long glMultiTexCoord3hNV;
/*      */   long glMultiTexCoord4hNV;
/*      */   long glFogCoordhNV;
/*      */   long glSecondaryColor3hNV;
/*      */   long glVertexWeighthNV;
/*      */   long glVertexAttrib1hNV;
/*      */   long glVertexAttrib2hNV;
/*      */   long glVertexAttrib3hNV;
/*      */   long glVertexAttrib4hNV;
/*      */   long glVertexAttribs1hvNV;
/*      */   long glVertexAttribs2hvNV;
/*      */   long glVertexAttribs3hvNV;
/*      */   long glVertexAttribs4hvNV;
/*      */   long glGenOcclusionQueriesNV;
/*      */   long glDeleteOcclusionQueriesNV;
/*      */   long glIsOcclusionQueryNV;
/*      */   long glBeginOcclusionQueryNV;
/*      */   long glEndOcclusionQueryNV;
/*      */   long glGetOcclusionQueryuivNV;
/*      */   long glGetOcclusionQueryivNV;
/*      */   long glProgramBufferParametersfvNV;
/*      */   long glProgramBufferParametersIivNV;
/*      */   long glProgramBufferParametersIuivNV;
/*      */   long glPathCommandsNV;
/*      */   long glPathCoordsNV;
/*      */   long glPathSubCommandsNV;
/*      */   long glPathSubCoordsNV;
/*      */   long glPathStringNV;
/*      */   long glPathGlyphsNV;
/*      */   long glPathGlyphRangeNV;
/*      */   long glWeightPathsNV;
/*      */   long glCopyPathNV;
/*      */   long glInterpolatePathsNV;
/*      */   long glTransformPathNV;
/*      */   long glPathParameterivNV;
/*      */   long glPathParameteriNV;
/*      */   long glPathParameterfvNV;
/*      */   long glPathParameterfNV;
/*      */   long glPathDashArrayNV;
/*      */   long glGenPathsNV;
/*      */   long glDeletePathsNV;
/*      */   long glIsPathNV;
/*      */   long glPathStencilFuncNV;
/*      */   long glPathStencilDepthOffsetNV;
/*      */   long glStencilFillPathNV;
/*      */   long glStencilStrokePathNV;
/*      */   long glStencilFillPathInstancedNV;
/*      */   long glStencilStrokePathInstancedNV;
/*      */   long glPathCoverDepthFuncNV;
/*      */   long glPathColorGenNV;
/*      */   long glPathTexGenNV;
/*      */   long glPathFogGenNV;
/*      */   long glCoverFillPathNV;
/*      */   long glCoverStrokePathNV;
/*      */   long glCoverFillPathInstancedNV;
/*      */   long glCoverStrokePathInstancedNV;
/*      */   long glGetPathParameterivNV;
/*      */   long glGetPathParameterfvNV;
/*      */   long glGetPathCommandsNV;
/*      */   long glGetPathCoordsNV;
/*      */   long glGetPathDashArrayNV;
/*      */   long glGetPathMetricsNV;
/*      */   long glGetPathMetricRangeNV;
/*      */   long glGetPathSpacingNV;
/*      */   long glGetPathColorGenivNV;
/*      */   long glGetPathColorGenfvNV;
/*      */   long glGetPathTexGenivNV;
/*      */   long glGetPathTexGenfvNV;
/*      */   long glIsPointInFillPathNV;
/*      */   long glIsPointInStrokePathNV;
/*      */   long glGetPathLengthNV;
/*      */   long glPointAlongPathNV;
/*      */   long glPixelDataRangeNV;
/*      */   long glFlushPixelDataRangeNV;
/*      */   long glPointParameteriNV;
/*      */   long glPointParameterivNV;
/*      */   long glPresentFrameKeyedNV;
/*      */   long glPresentFrameDualFillNV;
/*      */   long glGetVideoivNV;
/*      */   long glGetVideouivNV;
/*      */   long glGetVideoi64vNV;
/*      */   long glGetVideoui64vNV;
/*      */   long glPrimitiveRestartNV;
/*      */   long glPrimitiveRestartIndexNV;
/*      */   long glLoadProgramNV;
/*      */   long glBindProgramNV;
/*      */   long glDeleteProgramsNV;
/*      */   long glGenProgramsNV;
/*      */   long glGetProgramivNV;
/*      */   long glGetProgramStringNV;
/*      */   long glIsProgramNV;
/*      */   long glAreProgramsResidentNV;
/*      */   long glRequestResidentProgramsNV;
/*      */   long glCombinerParameterfNV;
/*      */   long glCombinerParameterfvNV;
/*      */   long glCombinerParameteriNV;
/*      */   long glCombinerParameterivNV;
/*      */   long glCombinerInputNV;
/*      */   long glCombinerOutputNV;
/*      */   long glFinalCombinerInputNV;
/*      */   long glGetCombinerInputParameterfvNV;
/*      */   long glGetCombinerInputParameterivNV;
/*      */   long glGetCombinerOutputParameterfvNV;
/*      */   long glGetCombinerOutputParameterivNV;
/*      */   long glGetFinalCombinerInputParameterfvNV;
/*      */   long glGetFinalCombinerInputParameterivNV;
/*      */   long glCombinerStageParameterfvNV;
/*      */   long glGetCombinerStageParameterfvNV;
/*      */   long glMakeBufferResidentNV;
/*      */   long glMakeBufferNonResidentNV;
/*      */   long glIsBufferResidentNV;
/*      */   long glMakeNamedBufferResidentNV;
/*      */   long glMakeNamedBufferNonResidentNV;
/*      */   long glIsNamedBufferResidentNV;
/*      */   long glGetBufferParameterui64vNV;
/*      */   long glGetNamedBufferParameterui64vNV;
/*      */   long glGetIntegerui64vNV;
/*      */   long glUniformui64NV;
/*      */   long glUniformui64vNV;
/*      */   long glProgramUniformui64NV;
/*      */   long glProgramUniformui64vNV;
/*      */   long glTextureBarrierNV;
/*      */   long glTexImage2DMultisampleCoverageNV;
/*      */   long glTexImage3DMultisampleCoverageNV;
/*      */   long glTextureImage2DMultisampleNV;
/*      */   long glTextureImage3DMultisampleNV;
/*      */   long glTextureImage2DMultisampleCoverageNV;
/*      */   long glTextureImage3DMultisampleCoverageNV;
/*      */   long glBindBufferRangeNV;
/*      */   long glBindBufferOffsetNV;
/*      */   long glBindBufferBaseNV;
/*      */   long glTransformFeedbackAttribsNV;
/*      */   long glTransformFeedbackVaryingsNV;
/*      */   long glBeginTransformFeedbackNV;
/*      */   long glEndTransformFeedbackNV;
/*      */   long glGetVaryingLocationNV;
/*      */   long glGetActiveVaryingNV;
/*      */   long glActiveVaryingNV;
/*      */   long glGetTransformFeedbackVaryingNV;
/*      */   long glBindTransformFeedbackNV;
/*      */   long glDeleteTransformFeedbacksNV;
/*      */   long glGenTransformFeedbacksNV;
/*      */   long glIsTransformFeedbackNV;
/*      */   long glPauseTransformFeedbackNV;
/*      */   long glResumeTransformFeedbackNV;
/*      */   long glDrawTransformFeedbackNV;
/*      */   long glVertexArrayRangeNV;
/*      */   long glFlushVertexArrayRangeNV;
/*      */   long glAllocateMemoryNV;
/*      */   long glFreeMemoryNV;
/*      */   long glVertexAttribL1i64NV;
/*      */   long glVertexAttribL2i64NV;
/*      */   long glVertexAttribL3i64NV;
/*      */   long glVertexAttribL4i64NV;
/*      */   long glVertexAttribL1i64vNV;
/*      */   long glVertexAttribL2i64vNV;
/*      */   long glVertexAttribL3i64vNV;
/*      */   long glVertexAttribL4i64vNV;
/*      */   long glVertexAttribL1ui64NV;
/*      */   long glVertexAttribL2ui64NV;
/*      */   long glVertexAttribL3ui64NV;
/*      */   long glVertexAttribL4ui64NV;
/*      */   long glVertexAttribL1ui64vNV;
/*      */   long glVertexAttribL2ui64vNV;
/*      */   long glVertexAttribL3ui64vNV;
/*      */   long glVertexAttribL4ui64vNV;
/*      */   long glGetVertexAttribLi64vNV;
/*      */   long glGetVertexAttribLui64vNV;
/*      */   long glVertexAttribLFormatNV;
/*      */   long glBufferAddressRangeNV;
/*      */   long glVertexFormatNV;
/*      */   long glNormalFormatNV;
/*      */   long glColorFormatNV;
/*      */   long glIndexFormatNV;
/*      */   long glTexCoordFormatNV;
/*      */   long glEdgeFlagFormatNV;
/*      */   long glSecondaryColorFormatNV;
/*      */   long glFogCoordFormatNV;
/*      */   long glVertexAttribFormatNV;
/*      */   long glVertexAttribIFormatNV;
/*      */   long glGetIntegerui64i_vNV;
/*      */   long glExecuteProgramNV;
/*      */   long glGetProgramParameterfvNV;
/*      */   long glGetProgramParameterdvNV;
/*      */   long glGetTrackMatrixivNV;
/*      */   long glGetVertexAttribfvNV;
/*      */   long glGetVertexAttribdvNV;
/*      */   long glGetVertexAttribivNV;
/*      */   long glGetVertexAttribPointervNV;
/*      */   long glProgramParameter4fNV;
/*      */   long glProgramParameter4dNV;
/*      */   long glProgramParameters4fvNV;
/*      */   long glProgramParameters4dvNV;
/*      */   long glTrackMatrixNV;
/*      */   long glVertexAttribPointerNV;
/*      */   long glVertexAttrib1sNV;
/*      */   long glVertexAttrib1fNV;
/*      */   long glVertexAttrib1dNV;
/*      */   long glVertexAttrib2sNV;
/*      */   long glVertexAttrib2fNV;
/*      */   long glVertexAttrib2dNV;
/*      */   long glVertexAttrib3sNV;
/*      */   long glVertexAttrib3fNV;
/*      */   long glVertexAttrib3dNV;
/*      */   long glVertexAttrib4sNV;
/*      */   long glVertexAttrib4fNV;
/*      */   long glVertexAttrib4dNV;
/*      */   long glVertexAttrib4ubNV;
/*      */   long glVertexAttribs1svNV;
/*      */   long glVertexAttribs1fvNV;
/*      */   long glVertexAttribs1dvNV;
/*      */   long glVertexAttribs2svNV;
/*      */   long glVertexAttribs2fvNV;
/*      */   long glVertexAttribs2dvNV;
/*      */   long glVertexAttribs3svNV;
/*      */   long glVertexAttribs3fvNV;
/*      */   long glVertexAttribs3dvNV;
/*      */   long glVertexAttribs4svNV;
/*      */   long glVertexAttribs4fvNV;
/*      */   long glVertexAttribs4dvNV;
/*      */   long glBeginVideoCaptureNV;
/*      */   long glBindVideoCaptureStreamBufferNV;
/*      */   long glBindVideoCaptureStreamTextureNV;
/*      */   long glEndVideoCaptureNV;
/*      */   long glGetVideoCaptureivNV;
/*      */   long glGetVideoCaptureStreamivNV;
/*      */   long glGetVideoCaptureStreamfvNV;
/*      */   long glGetVideoCaptureStreamdvNV;
/*      */   long glVideoCaptureNV;
/*      */   long glVideoCaptureStreamParameterivNV;
/*      */   long glVideoCaptureStreamParameterfvNV;
/*      */   long glVideoCaptureStreamParameterdvNV;
/*      */ 
/*      */   private boolean AMD_debug_output_initNativeFunctionAddresses()
/*      */   {
/* 2353 */     return ((this.glDebugMessageEnableAMD = GLContext.getFunctionAddress(new String[] { "glDebugMessageEnableAMD", "glDebugMessageEnableAMDX" })) != 0L ? 1 : 0) & ((this.glDebugMessageInsertAMD = GLContext.getFunctionAddress(new String[] { "glDebugMessageInsertAMD", "glDebugMessageInsertAMDX" })) != 0L ? 1 : 0) & ((this.glDebugMessageCallbackAMD = GLContext.getFunctionAddress(new String[] { "glDebugMessageCallbackAMD", "glDebugMessageCallbackAMDX" })) != 0L ? 1 : 0) & ((this.glGetDebugMessageLogAMD = GLContext.getFunctionAddress(new String[] { "glGetDebugMessageLogAMD", "glGetDebugMessageLogAMDX" })) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean AMD_draw_buffers_blend_initNativeFunctionAddresses()
/*      */   {
/* 2361 */     return ((this.glBlendFuncIndexedAMD = GLContext.getFunctionAddress("glBlendFuncIndexedAMD")) != 0L ? 1 : 0) & ((this.glBlendFuncSeparateIndexedAMD = GLContext.getFunctionAddress("glBlendFuncSeparateIndexedAMD")) != 0L ? 1 : 0) & ((this.glBlendEquationIndexedAMD = GLContext.getFunctionAddress("glBlendEquationIndexedAMD")) != 0L ? 1 : 0) & ((this.glBlendEquationSeparateIndexedAMD = GLContext.getFunctionAddress("glBlendEquationSeparateIndexedAMD")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean AMD_multi_draw_indirect_initNativeFunctionAddresses()
/*      */   {
/* 2369 */     return ((this.glMultiDrawArraysIndirectAMD = GLContext.getFunctionAddress("glMultiDrawArraysIndirectAMD")) != 0L ? 1 : 0) & ((this.glMultiDrawElementsIndirectAMD = GLContext.getFunctionAddress("glMultiDrawElementsIndirectAMD")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean AMD_name_gen_delete_initNativeFunctionAddresses()
/*      */   {
/* 2375 */     return ((this.glGenNamesAMD = GLContext.getFunctionAddress("glGenNamesAMD")) != 0L ? 1 : 0) & ((this.glDeleteNamesAMD = GLContext.getFunctionAddress("glDeleteNamesAMD")) != 0L ? 1 : 0) & ((this.glIsNameAMD = GLContext.getFunctionAddress("glIsNameAMD")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean AMD_performance_monitor_initNativeFunctionAddresses()
/*      */   {
/* 2382 */     return ((this.glGetPerfMonitorGroupsAMD = GLContext.getFunctionAddress("glGetPerfMonitorGroupsAMD")) != 0L ? 1 : 0) & ((this.glGetPerfMonitorCountersAMD = GLContext.getFunctionAddress("glGetPerfMonitorCountersAMD")) != 0L ? 1 : 0) & ((this.glGetPerfMonitorGroupStringAMD = GLContext.getFunctionAddress("glGetPerfMonitorGroupStringAMD")) != 0L ? 1 : 0) & ((this.glGetPerfMonitorCounterStringAMD = GLContext.getFunctionAddress("glGetPerfMonitorCounterStringAMD")) != 0L ? 1 : 0) & ((this.glGetPerfMonitorCounterInfoAMD = GLContext.getFunctionAddress("glGetPerfMonitorCounterInfoAMD")) != 0L ? 1 : 0) & ((this.glGenPerfMonitorsAMD = GLContext.getFunctionAddress("glGenPerfMonitorsAMD")) != 0L ? 1 : 0) & ((this.glDeletePerfMonitorsAMD = GLContext.getFunctionAddress("glDeletePerfMonitorsAMD")) != 0L ? 1 : 0) & ((this.glSelectPerfMonitorCountersAMD = GLContext.getFunctionAddress("glSelectPerfMonitorCountersAMD")) != 0L ? 1 : 0) & ((this.glBeginPerfMonitorAMD = GLContext.getFunctionAddress("glBeginPerfMonitorAMD")) != 0L ? 1 : 0) & ((this.glEndPerfMonitorAMD = GLContext.getFunctionAddress("glEndPerfMonitorAMD")) != 0L ? 1 : 0) & ((this.glGetPerfMonitorCounterDataAMD = GLContext.getFunctionAddress("glGetPerfMonitorCounterDataAMD")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean AMD_sample_positions_initNativeFunctionAddresses()
/*      */   {
/* 2397 */     return (this.glSetMultisamplefvAMD = GLContext.getFunctionAddress("glSetMultisamplefvAMD")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean AMD_sparse_texture_initNativeFunctionAddresses()
/*      */   {
/* 2402 */     return ((this.glTexStorageSparseAMD = GLContext.getFunctionAddress("glTexStorageSparseAMD")) != 0L ? 1 : 0) & ((this.glTextureStorageSparseAMD = GLContext.getFunctionAddress("glTextureStorageSparseAMD")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean AMD_stencil_operation_extended_initNativeFunctionAddresses()
/*      */   {
/* 2408 */     return (this.glStencilOpValueAMD = GLContext.getFunctionAddress("glStencilOpValueAMD")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean AMD_vertex_shader_tessellator_initNativeFunctionAddresses()
/*      */   {
/* 2413 */     return ((this.glTessellationFactorAMD = GLContext.getFunctionAddress("glTessellationFactorAMD")) != 0L ? 1 : 0) & ((this.glTessellationModeAMD = GLContext.getFunctionAddress("glTessellationModeAMD")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean APPLE_element_array_initNativeFunctionAddresses()
/*      */   {
/* 2419 */     return ((this.glElementPointerAPPLE = GLContext.getFunctionAddress("glElementPointerAPPLE")) != 0L ? 1 : 0) & ((this.glDrawElementArrayAPPLE = GLContext.getFunctionAddress("glDrawElementArrayAPPLE")) != 0L ? 1 : 0) & ((this.glDrawRangeElementArrayAPPLE = GLContext.getFunctionAddress("glDrawRangeElementArrayAPPLE")) != 0L ? 1 : 0) & ((this.glMultiDrawElementArrayAPPLE = GLContext.getFunctionAddress("glMultiDrawElementArrayAPPLE")) != 0L ? 1 : 0) & ((this.glMultiDrawRangeElementArrayAPPLE = GLContext.getFunctionAddress("glMultiDrawRangeElementArrayAPPLE")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean APPLE_fence_initNativeFunctionAddresses()
/*      */   {
/* 2428 */     return ((this.glGenFencesAPPLE = GLContext.getFunctionAddress("glGenFencesAPPLE")) != 0L ? 1 : 0) & ((this.glDeleteFencesAPPLE = GLContext.getFunctionAddress("glDeleteFencesAPPLE")) != 0L ? 1 : 0) & ((this.glSetFenceAPPLE = GLContext.getFunctionAddress("glSetFenceAPPLE")) != 0L ? 1 : 0) & ((this.glIsFenceAPPLE = GLContext.getFunctionAddress("glIsFenceAPPLE")) != 0L ? 1 : 0) & ((this.glTestFenceAPPLE = GLContext.getFunctionAddress("glTestFenceAPPLE")) != 0L ? 1 : 0) & ((this.glFinishFenceAPPLE = GLContext.getFunctionAddress("glFinishFenceAPPLE")) != 0L ? 1 : 0) & ((this.glTestObjectAPPLE = GLContext.getFunctionAddress("glTestObjectAPPLE")) != 0L ? 1 : 0) & ((this.glFinishObjectAPPLE = GLContext.getFunctionAddress("glFinishObjectAPPLE")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean APPLE_flush_buffer_range_initNativeFunctionAddresses()
/*      */   {
/* 2440 */     return ((this.glBufferParameteriAPPLE = GLContext.getFunctionAddress("glBufferParameteriAPPLE")) != 0L ? 1 : 0) & ((this.glFlushMappedBufferRangeAPPLE = GLContext.getFunctionAddress("glFlushMappedBufferRangeAPPLE")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean APPLE_object_purgeable_initNativeFunctionAddresses()
/*      */   {
/* 2446 */     return ((this.glObjectPurgeableAPPLE = GLContext.getFunctionAddress("glObjectPurgeableAPPLE")) != 0L ? 1 : 0) & ((this.glObjectUnpurgeableAPPLE = GLContext.getFunctionAddress("glObjectUnpurgeableAPPLE")) != 0L ? 1 : 0) & ((this.glGetObjectParameterivAPPLE = GLContext.getFunctionAddress("glGetObjectParameterivAPPLE")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean APPLE_texture_range_initNativeFunctionAddresses()
/*      */   {
/* 2453 */     return ((this.glTextureRangeAPPLE = GLContext.getFunctionAddress("glTextureRangeAPPLE")) != 0L ? 1 : 0) & ((this.glGetTexParameterPointervAPPLE = GLContext.getFunctionAddress("glGetTexParameterPointervAPPLE")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean APPLE_vertex_array_object_initNativeFunctionAddresses()
/*      */   {
/* 2459 */     return ((this.glBindVertexArrayAPPLE = GLContext.getFunctionAddress("glBindVertexArrayAPPLE")) != 0L ? 1 : 0) & ((this.glDeleteVertexArraysAPPLE = GLContext.getFunctionAddress("glDeleteVertexArraysAPPLE")) != 0L ? 1 : 0) & ((this.glGenVertexArraysAPPLE = GLContext.getFunctionAddress("glGenVertexArraysAPPLE")) != 0L ? 1 : 0) & ((this.glIsVertexArrayAPPLE = GLContext.getFunctionAddress("glIsVertexArrayAPPLE")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean APPLE_vertex_array_range_initNativeFunctionAddresses()
/*      */   {
/* 2467 */     return ((this.glVertexArrayRangeAPPLE = GLContext.getFunctionAddress("glVertexArrayRangeAPPLE")) != 0L ? 1 : 0) & ((this.glFlushVertexArrayRangeAPPLE = GLContext.getFunctionAddress("glFlushVertexArrayRangeAPPLE")) != 0L ? 1 : 0) & ((this.glVertexArrayParameteriAPPLE = GLContext.getFunctionAddress("glVertexArrayParameteriAPPLE")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean APPLE_vertex_program_evaluators_initNativeFunctionAddresses()
/*      */   {
/* 2474 */     return ((this.glEnableVertexAttribAPPLE = GLContext.getFunctionAddress("glEnableVertexAttribAPPLE")) != 0L ? 1 : 0) & ((this.glDisableVertexAttribAPPLE = GLContext.getFunctionAddress("glDisableVertexAttribAPPLE")) != 0L ? 1 : 0) & ((this.glIsVertexAttribEnabledAPPLE = GLContext.getFunctionAddress("glIsVertexAttribEnabledAPPLE")) != 0L ? 1 : 0) & ((this.glMapVertexAttrib1dAPPLE = GLContext.getFunctionAddress("glMapVertexAttrib1dAPPLE")) != 0L ? 1 : 0) & ((this.glMapVertexAttrib1fAPPLE = GLContext.getFunctionAddress("glMapVertexAttrib1fAPPLE")) != 0L ? 1 : 0) & ((this.glMapVertexAttrib2dAPPLE = GLContext.getFunctionAddress("glMapVertexAttrib2dAPPLE")) != 0L ? 1 : 0) & ((this.glMapVertexAttrib2fAPPLE = GLContext.getFunctionAddress("glMapVertexAttrib2fAPPLE")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_ES2_compatibility_initNativeFunctionAddresses()
/*      */   {
/* 2485 */     return ((this.glReleaseShaderCompiler = GLContext.getFunctionAddress("glReleaseShaderCompiler")) != 0L ? 1 : 0) & ((this.glShaderBinary = GLContext.getFunctionAddress("glShaderBinary")) != 0L ? 1 : 0) & ((this.glGetShaderPrecisionFormat = GLContext.getFunctionAddress("glGetShaderPrecisionFormat")) != 0L ? 1 : 0) & ((this.glDepthRangef = GLContext.getFunctionAddress("glDepthRangef")) != 0L ? 1 : 0) & ((this.glClearDepthf = GLContext.getFunctionAddress("glClearDepthf")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_base_instance_initNativeFunctionAddresses()
/*      */   {
/* 2494 */     return ((this.glDrawArraysInstancedBaseInstance = GLContext.getFunctionAddress("glDrawArraysInstancedBaseInstance")) != 0L ? 1 : 0) & ((this.glDrawElementsInstancedBaseInstance = GLContext.getFunctionAddress("glDrawElementsInstancedBaseInstance")) != 0L ? 1 : 0) & ((this.glDrawElementsInstancedBaseVertexBaseInstance = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertexBaseInstance")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_blend_func_extended_initNativeFunctionAddresses()
/*      */   {
/* 2501 */     return ((this.glBindFragDataLocationIndexed = GLContext.getFunctionAddress("glBindFragDataLocationIndexed")) != 0L ? 1 : 0) & ((this.glGetFragDataIndex = GLContext.getFunctionAddress("glGetFragDataIndex")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_buffer_object_initNativeFunctionAddresses()
/*      */   {
/* 2507 */     return ((this.glBindBufferARB = GLContext.getFunctionAddress("glBindBufferARB")) != 0L ? 1 : 0) & ((this.glDeleteBuffersARB = GLContext.getFunctionAddress("glDeleteBuffersARB")) != 0L ? 1 : 0) & ((this.glGenBuffersARB = GLContext.getFunctionAddress("glGenBuffersARB")) != 0L ? 1 : 0) & ((this.glIsBufferARB = GLContext.getFunctionAddress("glIsBufferARB")) != 0L ? 1 : 0) & ((this.glBufferDataARB = GLContext.getFunctionAddress("glBufferDataARB")) != 0L ? 1 : 0) & ((this.glBufferSubDataARB = GLContext.getFunctionAddress("glBufferSubDataARB")) != 0L ? 1 : 0) & ((this.glGetBufferSubDataARB = GLContext.getFunctionAddress("glGetBufferSubDataARB")) != 0L ? 1 : 0) & ((this.glMapBufferARB = GLContext.getFunctionAddress("glMapBufferARB")) != 0L ? 1 : 0) & ((this.glUnmapBufferARB = GLContext.getFunctionAddress("glUnmapBufferARB")) != 0L ? 1 : 0) & ((this.glGetBufferParameterivARB = GLContext.getFunctionAddress("glGetBufferParameterivARB")) != 0L ? 1 : 0) & ((this.glGetBufferPointervARB = GLContext.getFunctionAddress("glGetBufferPointervARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_cl_event_initNativeFunctionAddresses()
/*      */   {
/* 2522 */     return (this.glCreateSyncFromCLeventARB = GLContext.getFunctionAddress("glCreateSyncFromCLeventARB")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_clear_buffer_object_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 2527 */     return ((this.glClearBufferData = GLContext.getFunctionAddress("glClearBufferData")) != 0L ? 1 : 0) & ((this.glClearBufferSubData = GLContext.getFunctionAddress("glClearBufferSubData")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glClearNamedBufferDataEXT = GLContext.getFunctionAddress("glClearNamedBufferDataEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glClearNamedBufferSubDataEXT = GLContext.getFunctionAddress("glClearNamedBufferSubDataEXT")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_color_buffer_float_initNativeFunctionAddresses()
/*      */   {
/* 2535 */     return (this.glClampColorARB = GLContext.getFunctionAddress("glClampColorARB")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_compute_shader_initNativeFunctionAddresses()
/*      */   {
/* 2540 */     return ((this.glDispatchCompute = GLContext.getFunctionAddress("glDispatchCompute")) != 0L ? 1 : 0) & ((this.glDispatchComputeIndirect = GLContext.getFunctionAddress("glDispatchComputeIndirect")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_copy_buffer_initNativeFunctionAddresses()
/*      */   {
/* 2546 */     return (this.glCopyBufferSubData = GLContext.getFunctionAddress("glCopyBufferSubData")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_copy_image_initNativeFunctionAddresses()
/*      */   {
/* 2551 */     return (this.glCopyImageSubData = GLContext.getFunctionAddress("glCopyImageSubData")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_debug_output_initNativeFunctionAddresses()
/*      */   {
/* 2556 */     return ((this.glDebugMessageControlARB = GLContext.getFunctionAddress("glDebugMessageControlARB")) != 0L ? 1 : 0) & ((this.glDebugMessageInsertARB = GLContext.getFunctionAddress("glDebugMessageInsertARB")) != 0L ? 1 : 0) & ((this.glDebugMessageCallbackARB = GLContext.getFunctionAddress("glDebugMessageCallbackARB")) != 0L ? 1 : 0) & ((this.glGetDebugMessageLogARB = GLContext.getFunctionAddress("glGetDebugMessageLogARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_draw_buffers_initNativeFunctionAddresses()
/*      */   {
/* 2564 */     return (this.glDrawBuffersARB = GLContext.getFunctionAddress("glDrawBuffersARB")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_draw_buffers_blend_initNativeFunctionAddresses()
/*      */   {
/* 2569 */     return ((this.glBlendEquationiARB = GLContext.getFunctionAddress("glBlendEquationiARB")) != 0L ? 1 : 0) & ((this.glBlendEquationSeparateiARB = GLContext.getFunctionAddress("glBlendEquationSeparateiARB")) != 0L ? 1 : 0) & ((this.glBlendFunciARB = GLContext.getFunctionAddress("glBlendFunciARB")) != 0L ? 1 : 0) & ((this.glBlendFuncSeparateiARB = GLContext.getFunctionAddress("glBlendFuncSeparateiARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_draw_elements_base_vertex_initNativeFunctionAddresses()
/*      */   {
/* 2577 */     return ((this.glDrawElementsBaseVertex = GLContext.getFunctionAddress("glDrawElementsBaseVertex")) != 0L ? 1 : 0) & ((this.glDrawRangeElementsBaseVertex = GLContext.getFunctionAddress("glDrawRangeElementsBaseVertex")) != 0L ? 1 : 0) & ((this.glDrawElementsInstancedBaseVertex = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertex")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_draw_indirect_initNativeFunctionAddresses()
/*      */   {
/* 2584 */     return ((this.glDrawArraysIndirect = GLContext.getFunctionAddress("glDrawArraysIndirect")) != 0L ? 1 : 0) & ((this.glDrawElementsIndirect = GLContext.getFunctionAddress("glDrawElementsIndirect")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_draw_instanced_initNativeFunctionAddresses()
/*      */   {
/* 2590 */     return ((this.glDrawArraysInstancedARB = GLContext.getFunctionAddress("glDrawArraysInstancedARB")) != 0L ? 1 : 0) & ((this.glDrawElementsInstancedARB = GLContext.getFunctionAddress("glDrawElementsInstancedARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_framebuffer_no_attachments_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 2596 */     return ((this.glFramebufferParameteri = GLContext.getFunctionAddress("glFramebufferParameteri")) != 0L ? 1 : 0) & ((this.glGetFramebufferParameteriv = GLContext.getFunctionAddress("glGetFramebufferParameteriv")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glNamedFramebufferParameteriEXT = GLContext.getFunctionAddress("glNamedFramebufferParameteriEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glGetNamedFramebufferParameterivEXT = GLContext.getFunctionAddress("glGetNamedFramebufferParameterivEXT")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_framebuffer_object_initNativeFunctionAddresses()
/*      */   {
/* 2604 */     return ((this.glIsRenderbuffer = GLContext.getFunctionAddress("glIsRenderbuffer")) != 0L ? 1 : 0) & ((this.glBindRenderbuffer = GLContext.getFunctionAddress("glBindRenderbuffer")) != 0L ? 1 : 0) & ((this.glDeleteRenderbuffers = GLContext.getFunctionAddress("glDeleteRenderbuffers")) != 0L ? 1 : 0) & ((this.glGenRenderbuffers = GLContext.getFunctionAddress("glGenRenderbuffers")) != 0L ? 1 : 0) & ((this.glRenderbufferStorage = GLContext.getFunctionAddress("glRenderbufferStorage")) != 0L ? 1 : 0) & ((this.glRenderbufferStorageMultisample = GLContext.getFunctionAddress("glRenderbufferStorageMultisample")) != 0L ? 1 : 0) & ((this.glGetRenderbufferParameteriv = GLContext.getFunctionAddress("glGetRenderbufferParameteriv")) != 0L ? 1 : 0) & ((this.glIsFramebuffer = GLContext.getFunctionAddress("glIsFramebuffer")) != 0L ? 1 : 0) & ((this.glBindFramebuffer = GLContext.getFunctionAddress("glBindFramebuffer")) != 0L ? 1 : 0) & ((this.glDeleteFramebuffers = GLContext.getFunctionAddress("glDeleteFramebuffers")) != 0L ? 1 : 0) & ((this.glGenFramebuffers = GLContext.getFunctionAddress("glGenFramebuffers")) != 0L ? 1 : 0) & ((this.glCheckFramebufferStatus = GLContext.getFunctionAddress("glCheckFramebufferStatus")) != 0L ? 1 : 0) & ((this.glFramebufferTexture1D = GLContext.getFunctionAddress("glFramebufferTexture1D")) != 0L ? 1 : 0) & ((this.glFramebufferTexture2D = GLContext.getFunctionAddress("glFramebufferTexture2D")) != 0L ? 1 : 0) & ((this.glFramebufferTexture3D = GLContext.getFunctionAddress("glFramebufferTexture3D")) != 0L ? 1 : 0) & ((this.glFramebufferTextureLayer = GLContext.getFunctionAddress("glFramebufferTextureLayer")) != 0L ? 1 : 0) & ((this.glFramebufferRenderbuffer = GLContext.getFunctionAddress("glFramebufferRenderbuffer")) != 0L ? 1 : 0) & ((this.glGetFramebufferAttachmentParameteriv = GLContext.getFunctionAddress("glGetFramebufferAttachmentParameteriv")) != 0L ? 1 : 0) & ((this.glBlitFramebuffer = GLContext.getFunctionAddress("glBlitFramebuffer")) != 0L ? 1 : 0) & ((this.glGenerateMipmap = GLContext.getFunctionAddress("glGenerateMipmap")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_geometry_shader4_initNativeFunctionAddresses()
/*      */   {
/* 2628 */     return ((this.glProgramParameteriARB = GLContext.getFunctionAddress("glProgramParameteriARB")) != 0L ? 1 : 0) & ((this.glFramebufferTextureARB = GLContext.getFunctionAddress("glFramebufferTextureARB")) != 0L ? 1 : 0) & ((this.glFramebufferTextureLayerARB = GLContext.getFunctionAddress("glFramebufferTextureLayerARB")) != 0L ? 1 : 0) & ((this.glFramebufferTextureFaceARB = GLContext.getFunctionAddress("glFramebufferTextureFaceARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_get_program_binary_initNativeFunctionAddresses()
/*      */   {
/* 2636 */     return ((this.glGetProgramBinary = GLContext.getFunctionAddress("glGetProgramBinary")) != 0L ? 1 : 0) & ((this.glProgramBinary = GLContext.getFunctionAddress("glProgramBinary")) != 0L ? 1 : 0) & ((this.glProgramParameteri = GLContext.getFunctionAddress("glProgramParameteri")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_gpu_shader_fp64_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 2643 */     return ((this.glUniform1d = GLContext.getFunctionAddress("glUniform1d")) != 0L ? 1 : 0) & ((this.glUniform2d = GLContext.getFunctionAddress("glUniform2d")) != 0L ? 1 : 0) & ((this.glUniform3d = GLContext.getFunctionAddress("glUniform3d")) != 0L ? 1 : 0) & ((this.glUniform4d = GLContext.getFunctionAddress("glUniform4d")) != 0L ? 1 : 0) & ((this.glUniform1dv = GLContext.getFunctionAddress("glUniform1dv")) != 0L ? 1 : 0) & ((this.glUniform2dv = GLContext.getFunctionAddress("glUniform2dv")) != 0L ? 1 : 0) & ((this.glUniform3dv = GLContext.getFunctionAddress("glUniform3dv")) != 0L ? 1 : 0) & ((this.glUniform4dv = GLContext.getFunctionAddress("glUniform4dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix2dv = GLContext.getFunctionAddress("glUniformMatrix2dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix3dv = GLContext.getFunctionAddress("glUniformMatrix3dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix4dv = GLContext.getFunctionAddress("glUniformMatrix4dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix2x3dv = GLContext.getFunctionAddress("glUniformMatrix2x3dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix2x4dv = GLContext.getFunctionAddress("glUniformMatrix2x4dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix3x2dv = GLContext.getFunctionAddress("glUniformMatrix3x2dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix3x4dv = GLContext.getFunctionAddress("glUniformMatrix3x4dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix4x2dv = GLContext.getFunctionAddress("glUniformMatrix4x2dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix4x3dv = GLContext.getFunctionAddress("glUniformMatrix4x3dv")) != 0L ? 1 : 0) & ((this.glGetUniformdv = GLContext.getFunctionAddress("glGetUniformdv")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform1dEXT = GLContext.getFunctionAddress("glProgramUniform1dEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform2dEXT = GLContext.getFunctionAddress("glProgramUniform2dEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform3dEXT = GLContext.getFunctionAddress("glProgramUniform3dEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform4dEXT = GLContext.getFunctionAddress("glProgramUniform4dEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform1dvEXT = GLContext.getFunctionAddress("glProgramUniform1dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform2dvEXT = GLContext.getFunctionAddress("glProgramUniform2dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform3dvEXT = GLContext.getFunctionAddress("glProgramUniform3dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform4dvEXT = GLContext.getFunctionAddress("glProgramUniform4dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniformMatrix2dvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix2dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniformMatrix3dvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix3dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniformMatrix4dvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix4dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniformMatrix2x3dvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix2x3dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniformMatrix2x4dvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix2x4dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniformMatrix3x2dvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix3x2dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniformMatrix3x4dvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix3x4dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniformMatrix4x2dvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix4x2dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniformMatrix4x3dvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix4x3dvEXT")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_imaging_initNativeFunctionAddresses(boolean forwardCompatible)
/*      */   {
/* 2682 */     return ((forwardCompatible) || ((this.glColorTable = GLContext.getFunctionAddress("glColorTable")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColorSubTable = GLContext.getFunctionAddress("glColorSubTable")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColorTableParameteriv = GLContext.getFunctionAddress("glColorTableParameteriv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColorTableParameterfv = GLContext.getFunctionAddress("glColorTableParameterfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glCopyColorSubTable = GLContext.getFunctionAddress("glCopyColorSubTable")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glCopyColorTable = GLContext.getFunctionAddress("glCopyColorTable")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetColorTable = GLContext.getFunctionAddress("glGetColorTable")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetColorTableParameteriv = GLContext.getFunctionAddress("glGetColorTableParameteriv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetColorTableParameterfv = GLContext.getFunctionAddress("glGetColorTableParameterfv")) != 0L) ? 1 : 0) & ((this.glBlendEquation = GLContext.getFunctionAddress("glBlendEquation")) != 0L ? 1 : 0) & ((this.glBlendColor = GLContext.getFunctionAddress("glBlendColor")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glHistogram = GLContext.getFunctionAddress("glHistogram")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glResetHistogram = GLContext.getFunctionAddress("glResetHistogram")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetHistogram = GLContext.getFunctionAddress("glGetHistogram")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetHistogramParameterfv = GLContext.getFunctionAddress("glGetHistogramParameterfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetHistogramParameteriv = GLContext.getFunctionAddress("glGetHistogramParameteriv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMinmax = GLContext.getFunctionAddress("glMinmax")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glResetMinmax = GLContext.getFunctionAddress("glResetMinmax")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetMinmax = GLContext.getFunctionAddress("glGetMinmax")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetMinmaxParameterfv = GLContext.getFunctionAddress("glGetMinmaxParameterfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetMinmaxParameteriv = GLContext.getFunctionAddress("glGetMinmaxParameteriv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glConvolutionFilter1D = GLContext.getFunctionAddress("glConvolutionFilter1D")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glConvolutionFilter2D = GLContext.getFunctionAddress("glConvolutionFilter2D")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glConvolutionParameterf = GLContext.getFunctionAddress("glConvolutionParameterf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glConvolutionParameterfv = GLContext.getFunctionAddress("glConvolutionParameterfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glConvolutionParameteri = GLContext.getFunctionAddress("glConvolutionParameteri")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glConvolutionParameteriv = GLContext.getFunctionAddress("glConvolutionParameteriv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glCopyConvolutionFilter1D = GLContext.getFunctionAddress("glCopyConvolutionFilter1D")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glCopyConvolutionFilter2D = GLContext.getFunctionAddress("glCopyConvolutionFilter2D")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetConvolutionFilter = GLContext.getFunctionAddress("glGetConvolutionFilter")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetConvolutionParameterfv = GLContext.getFunctionAddress("glGetConvolutionParameterfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetConvolutionParameteriv = GLContext.getFunctionAddress("glGetConvolutionParameteriv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glSeparableFilter2D = GLContext.getFunctionAddress("glSeparableFilter2D")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetSeparableFilter = GLContext.getFunctionAddress("glGetSeparableFilter")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_instanced_arrays_initNativeFunctionAddresses()
/*      */   {
/* 2720 */     return (this.glVertexAttribDivisorARB = GLContext.getFunctionAddress("glVertexAttribDivisorARB")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_internalformat_query_initNativeFunctionAddresses()
/*      */   {
/* 2725 */     return (this.glGetInternalformativ = GLContext.getFunctionAddress("glGetInternalformativ")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_internalformat_query2_initNativeFunctionAddresses()
/*      */   {
/* 2730 */     return (this.glGetInternalformati64v = GLContext.getFunctionAddress("glGetInternalformati64v")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_invalidate_subdata_initNativeFunctionAddresses()
/*      */   {
/* 2735 */     return ((this.glInvalidateTexSubImage = GLContext.getFunctionAddress("glInvalidateTexSubImage")) != 0L ? 1 : 0) & ((this.glInvalidateTexImage = GLContext.getFunctionAddress("glInvalidateTexImage")) != 0L ? 1 : 0) & ((this.glInvalidateBufferSubData = GLContext.getFunctionAddress("glInvalidateBufferSubData")) != 0L ? 1 : 0) & ((this.glInvalidateBufferData = GLContext.getFunctionAddress("glInvalidateBufferData")) != 0L ? 1 : 0) & ((this.glInvalidateFramebuffer = GLContext.getFunctionAddress("glInvalidateFramebuffer")) != 0L ? 1 : 0) & ((this.glInvalidateSubFramebuffer = GLContext.getFunctionAddress("glInvalidateSubFramebuffer")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_map_buffer_range_initNativeFunctionAddresses()
/*      */   {
/* 2745 */     return ((this.glMapBufferRange = GLContext.getFunctionAddress("glMapBufferRange")) != 0L ? 1 : 0) & ((this.glFlushMappedBufferRange = GLContext.getFunctionAddress("glFlushMappedBufferRange")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_matrix_palette_initNativeFunctionAddresses()
/*      */   {
/* 2751 */     return ((this.glCurrentPaletteMatrixARB = GLContext.getFunctionAddress("glCurrentPaletteMatrixARB")) != 0L ? 1 : 0) & ((this.glMatrixIndexPointerARB = GLContext.getFunctionAddress("glMatrixIndexPointerARB")) != 0L ? 1 : 0) & ((this.glMatrixIndexubvARB = GLContext.getFunctionAddress("glMatrixIndexubvARB")) != 0L ? 1 : 0) & ((this.glMatrixIndexusvARB = GLContext.getFunctionAddress("glMatrixIndexusvARB")) != 0L ? 1 : 0) & ((this.glMatrixIndexuivARB = GLContext.getFunctionAddress("glMatrixIndexuivARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_multi_draw_indirect_initNativeFunctionAddresses()
/*      */   {
/* 2760 */     return ((this.glMultiDrawArraysIndirect = GLContext.getFunctionAddress("glMultiDrawArraysIndirect")) != 0L ? 1 : 0) & ((this.glMultiDrawElementsIndirect = GLContext.getFunctionAddress("glMultiDrawElementsIndirect")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_multisample_initNativeFunctionAddresses()
/*      */   {
/* 2766 */     return (this.glSampleCoverageARB = GLContext.getFunctionAddress("glSampleCoverageARB")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_multitexture_initNativeFunctionAddresses()
/*      */   {
/* 2771 */     return ((this.glClientActiveTextureARB = GLContext.getFunctionAddress("glClientActiveTextureARB")) != 0L ? 1 : 0) & ((this.glActiveTextureARB = GLContext.getFunctionAddress("glActiveTextureARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord1fARB = GLContext.getFunctionAddress("glMultiTexCoord1fARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord1dARB = GLContext.getFunctionAddress("glMultiTexCoord1dARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord1iARB = GLContext.getFunctionAddress("glMultiTexCoord1iARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord1sARB = GLContext.getFunctionAddress("glMultiTexCoord1sARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord2fARB = GLContext.getFunctionAddress("glMultiTexCoord2fARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord2dARB = GLContext.getFunctionAddress("glMultiTexCoord2dARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord2iARB = GLContext.getFunctionAddress("glMultiTexCoord2iARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord2sARB = GLContext.getFunctionAddress("glMultiTexCoord2sARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord3fARB = GLContext.getFunctionAddress("glMultiTexCoord3fARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord3dARB = GLContext.getFunctionAddress("glMultiTexCoord3dARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord3iARB = GLContext.getFunctionAddress("glMultiTexCoord3iARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord3sARB = GLContext.getFunctionAddress("glMultiTexCoord3sARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord4fARB = GLContext.getFunctionAddress("glMultiTexCoord4fARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord4dARB = GLContext.getFunctionAddress("glMultiTexCoord4dARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord4iARB = GLContext.getFunctionAddress("glMultiTexCoord4iARB")) != 0L ? 1 : 0) & ((this.glMultiTexCoord4sARB = GLContext.getFunctionAddress("glMultiTexCoord4sARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_occlusion_query_initNativeFunctionAddresses()
/*      */   {
/* 2793 */     return ((this.glGenQueriesARB = GLContext.getFunctionAddress("glGenQueriesARB")) != 0L ? 1 : 0) & ((this.glDeleteQueriesARB = GLContext.getFunctionAddress("glDeleteQueriesARB")) != 0L ? 1 : 0) & ((this.glIsQueryARB = GLContext.getFunctionAddress("glIsQueryARB")) != 0L ? 1 : 0) & ((this.glBeginQueryARB = GLContext.getFunctionAddress("glBeginQueryARB")) != 0L ? 1 : 0) & ((this.glEndQueryARB = GLContext.getFunctionAddress("glEndQueryARB")) != 0L ? 1 : 0) & ((this.glGetQueryivARB = GLContext.getFunctionAddress("glGetQueryivARB")) != 0L ? 1 : 0) & ((this.glGetQueryObjectivARB = GLContext.getFunctionAddress("glGetQueryObjectivARB")) != 0L ? 1 : 0) & ((this.glGetQueryObjectuivARB = GLContext.getFunctionAddress("glGetQueryObjectuivARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_point_parameters_initNativeFunctionAddresses()
/*      */   {
/* 2805 */     return ((this.glPointParameterfARB = GLContext.getFunctionAddress("glPointParameterfARB")) != 0L ? 1 : 0) & ((this.glPointParameterfvARB = GLContext.getFunctionAddress("glPointParameterfvARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_program_initNativeFunctionAddresses()
/*      */   {
/* 2811 */     return ((this.glProgramStringARB = GLContext.getFunctionAddress("glProgramStringARB")) != 0L ? 1 : 0) & ((this.glBindProgramARB = GLContext.getFunctionAddress("glBindProgramARB")) != 0L ? 1 : 0) & ((this.glDeleteProgramsARB = GLContext.getFunctionAddress("glDeleteProgramsARB")) != 0L ? 1 : 0) & ((this.glGenProgramsARB = GLContext.getFunctionAddress("glGenProgramsARB")) != 0L ? 1 : 0) & ((this.glProgramEnvParameter4fARB = GLContext.getFunctionAddress("glProgramEnvParameter4fARB")) != 0L ? 1 : 0) & ((this.glProgramEnvParameter4dARB = GLContext.getFunctionAddress("glProgramEnvParameter4dARB")) != 0L ? 1 : 0) & ((this.glProgramEnvParameter4fvARB = GLContext.getFunctionAddress("glProgramEnvParameter4fvARB")) != 0L ? 1 : 0) & ((this.glProgramEnvParameter4dvARB = GLContext.getFunctionAddress("glProgramEnvParameter4dvARB")) != 0L ? 1 : 0) & ((this.glProgramLocalParameter4fARB = GLContext.getFunctionAddress("glProgramLocalParameter4fARB")) != 0L ? 1 : 0) & ((this.glProgramLocalParameter4dARB = GLContext.getFunctionAddress("glProgramLocalParameter4dARB")) != 0L ? 1 : 0) & ((this.glProgramLocalParameter4fvARB = GLContext.getFunctionAddress("glProgramLocalParameter4fvARB")) != 0L ? 1 : 0) & ((this.glProgramLocalParameter4dvARB = GLContext.getFunctionAddress("glProgramLocalParameter4dvARB")) != 0L ? 1 : 0) & ((this.glGetProgramEnvParameterfvARB = GLContext.getFunctionAddress("glGetProgramEnvParameterfvARB")) != 0L ? 1 : 0) & ((this.glGetProgramEnvParameterdvARB = GLContext.getFunctionAddress("glGetProgramEnvParameterdvARB")) != 0L ? 1 : 0) & ((this.glGetProgramLocalParameterfvARB = GLContext.getFunctionAddress("glGetProgramLocalParameterfvARB")) != 0L ? 1 : 0) & ((this.glGetProgramLocalParameterdvARB = GLContext.getFunctionAddress("glGetProgramLocalParameterdvARB")) != 0L ? 1 : 0) & ((this.glGetProgramivARB = GLContext.getFunctionAddress("glGetProgramivARB")) != 0L ? 1 : 0) & ((this.glGetProgramStringARB = GLContext.getFunctionAddress("glGetProgramStringARB")) != 0L ? 1 : 0) & ((this.glIsProgramARB = GLContext.getFunctionAddress("glIsProgramARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_program_interface_query_initNativeFunctionAddresses()
/*      */   {
/* 2834 */     return ((this.glGetProgramInterfaceiv = GLContext.getFunctionAddress("glGetProgramInterfaceiv")) != 0L ? 1 : 0) & ((this.glGetProgramResourceIndex = GLContext.getFunctionAddress("glGetProgramResourceIndex")) != 0L ? 1 : 0) & ((this.glGetProgramResourceName = GLContext.getFunctionAddress("glGetProgramResourceName")) != 0L ? 1 : 0) & ((this.glGetProgramResourceiv = GLContext.getFunctionAddress("glGetProgramResourceiv")) != 0L ? 1 : 0) & ((this.glGetProgramResourceLocation = GLContext.getFunctionAddress("glGetProgramResourceLocation")) != 0L ? 1 : 0) & ((this.glGetProgramResourceLocationIndex = GLContext.getFunctionAddress("glGetProgramResourceLocationIndex")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_provoking_vertex_initNativeFunctionAddresses()
/*      */   {
/* 2844 */     return (this.glProvokingVertex = GLContext.getFunctionAddress("glProvokingVertex")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_robustness_initNativeFunctionAddresses(boolean forwardCompatible, Set<String> supported_extensions)
/*      */   {
/* 2849 */     return ((this.glGetGraphicsResetStatusARB = GLContext.getFunctionAddress("glGetGraphicsResetStatusARB")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glGetnMapdvARB = GLContext.getFunctionAddress("glGetnMapdvARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetnMapfvARB = GLContext.getFunctionAddress("glGetnMapfvARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetnMapivARB = GLContext.getFunctionAddress("glGetnMapivARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetnPixelMapfvARB = GLContext.getFunctionAddress("glGetnPixelMapfvARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetnPixelMapuivARB = GLContext.getFunctionAddress("glGetnPixelMapuivARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetnPixelMapusvARB = GLContext.getFunctionAddress("glGetnPixelMapusvARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetnPolygonStippleARB = GLContext.getFunctionAddress("glGetnPolygonStippleARB")) != 0L) ? 1 : 0) & ((this.glGetnTexImageARB = GLContext.getFunctionAddress("glGetnTexImageARB")) != 0L ? 1 : 0) & ((this.glReadnPixelsARB = GLContext.getFunctionAddress("glReadnPixelsARB")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_imaging")) || ((this.glGetnColorTableARB = GLContext.getFunctionAddress("glGetnColorTableARB")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_imaging")) || ((this.glGetnConvolutionFilterARB = GLContext.getFunctionAddress("glGetnConvolutionFilterARB")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_imaging")) || ((this.glGetnSeparableFilterARB = GLContext.getFunctionAddress("glGetnSeparableFilterARB")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_imaging")) || ((this.glGetnHistogramARB = GLContext.getFunctionAddress("glGetnHistogramARB")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_imaging")) || ((this.glGetnMinmaxARB = GLContext.getFunctionAddress("glGetnMinmaxARB")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetnCompressedTexImageARB = GLContext.getFunctionAddress("glGetnCompressedTexImageARB")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glGetnUniformfvARB = GLContext.getFunctionAddress("glGetnUniformfvARB")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glGetnUniformivARB = GLContext.getFunctionAddress("glGetnUniformivARB")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glGetnUniformuivARB = GLContext.getFunctionAddress("glGetnUniformuivARB")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glGetnUniformdvARB = GLContext.getFunctionAddress("glGetnUniformdvARB")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_sample_shading_initNativeFunctionAddresses()
/*      */   {
/* 2873 */     return (this.glMinSampleShadingARB = GLContext.getFunctionAddress("glMinSampleShadingARB")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_sampler_objects_initNativeFunctionAddresses()
/*      */   {
/* 2878 */     return ((this.glGenSamplers = GLContext.getFunctionAddress("glGenSamplers")) != 0L ? 1 : 0) & ((this.glDeleteSamplers = GLContext.getFunctionAddress("glDeleteSamplers")) != 0L ? 1 : 0) & ((this.glIsSampler = GLContext.getFunctionAddress("glIsSampler")) != 0L ? 1 : 0) & ((this.glBindSampler = GLContext.getFunctionAddress("glBindSampler")) != 0L ? 1 : 0) & ((this.glSamplerParameteri = GLContext.getFunctionAddress("glSamplerParameteri")) != 0L ? 1 : 0) & ((this.glSamplerParameterf = GLContext.getFunctionAddress("glSamplerParameterf")) != 0L ? 1 : 0) & ((this.glSamplerParameteriv = GLContext.getFunctionAddress("glSamplerParameteriv")) != 0L ? 1 : 0) & ((this.glSamplerParameterfv = GLContext.getFunctionAddress("glSamplerParameterfv")) != 0L ? 1 : 0) & ((this.glSamplerParameterIiv = GLContext.getFunctionAddress("glSamplerParameterIiv")) != 0L ? 1 : 0) & ((this.glSamplerParameterIuiv = GLContext.getFunctionAddress("glSamplerParameterIuiv")) != 0L ? 1 : 0) & ((this.glGetSamplerParameteriv = GLContext.getFunctionAddress("glGetSamplerParameteriv")) != 0L ? 1 : 0) & ((this.glGetSamplerParameterfv = GLContext.getFunctionAddress("glGetSamplerParameterfv")) != 0L ? 1 : 0) & ((this.glGetSamplerParameterIiv = GLContext.getFunctionAddress("glGetSamplerParameterIiv")) != 0L ? 1 : 0) & ((this.glGetSamplerParameterIuiv = GLContext.getFunctionAddress("glGetSamplerParameterIuiv")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_separate_shader_objects_initNativeFunctionAddresses()
/*      */   {
/* 2896 */     return ((this.glUseProgramStages = GLContext.getFunctionAddress("glUseProgramStages")) != 0L ? 1 : 0) & ((this.glActiveShaderProgram = GLContext.getFunctionAddress("glActiveShaderProgram")) != 0L ? 1 : 0) & ((this.glCreateShaderProgramv = GLContext.getFunctionAddress("glCreateShaderProgramv")) != 0L ? 1 : 0) & ((this.glBindProgramPipeline = GLContext.getFunctionAddress("glBindProgramPipeline")) != 0L ? 1 : 0) & ((this.glDeleteProgramPipelines = GLContext.getFunctionAddress("glDeleteProgramPipelines")) != 0L ? 1 : 0) & ((this.glGenProgramPipelines = GLContext.getFunctionAddress("glGenProgramPipelines")) != 0L ? 1 : 0) & ((this.glIsProgramPipeline = GLContext.getFunctionAddress("glIsProgramPipeline")) != 0L ? 1 : 0) & ((this.glProgramParameteri = GLContext.getFunctionAddress("glProgramParameteri")) != 0L ? 1 : 0) & ((this.glGetProgramPipelineiv = GLContext.getFunctionAddress("glGetProgramPipelineiv")) != 0L ? 1 : 0) & ((this.glProgramUniform1i = GLContext.getFunctionAddress("glProgramUniform1i")) != 0L ? 1 : 0) & ((this.glProgramUniform2i = GLContext.getFunctionAddress("glProgramUniform2i")) != 0L ? 1 : 0) & ((this.glProgramUniform3i = GLContext.getFunctionAddress("glProgramUniform3i")) != 0L ? 1 : 0) & ((this.glProgramUniform4i = GLContext.getFunctionAddress("glProgramUniform4i")) != 0L ? 1 : 0) & ((this.glProgramUniform1f = GLContext.getFunctionAddress("glProgramUniform1f")) != 0L ? 1 : 0) & ((this.glProgramUniform2f = GLContext.getFunctionAddress("glProgramUniform2f")) != 0L ? 1 : 0) & ((this.glProgramUniform3f = GLContext.getFunctionAddress("glProgramUniform3f")) != 0L ? 1 : 0) & ((this.glProgramUniform4f = GLContext.getFunctionAddress("glProgramUniform4f")) != 0L ? 1 : 0) & ((this.glProgramUniform1d = GLContext.getFunctionAddress("glProgramUniform1d")) != 0L ? 1 : 0) & ((this.glProgramUniform2d = GLContext.getFunctionAddress("glProgramUniform2d")) != 0L ? 1 : 0) & ((this.glProgramUniform3d = GLContext.getFunctionAddress("glProgramUniform3d")) != 0L ? 1 : 0) & ((this.glProgramUniform4d = GLContext.getFunctionAddress("glProgramUniform4d")) != 0L ? 1 : 0) & ((this.glProgramUniform1iv = GLContext.getFunctionAddress("glProgramUniform1iv")) != 0L ? 1 : 0) & ((this.glProgramUniform2iv = GLContext.getFunctionAddress("glProgramUniform2iv")) != 0L ? 1 : 0) & ((this.glProgramUniform3iv = GLContext.getFunctionAddress("glProgramUniform3iv")) != 0L ? 1 : 0) & ((this.glProgramUniform4iv = GLContext.getFunctionAddress("glProgramUniform4iv")) != 0L ? 1 : 0) & ((this.glProgramUniform1fv = GLContext.getFunctionAddress("glProgramUniform1fv")) != 0L ? 1 : 0) & ((this.glProgramUniform2fv = GLContext.getFunctionAddress("glProgramUniform2fv")) != 0L ? 1 : 0) & ((this.glProgramUniform3fv = GLContext.getFunctionAddress("glProgramUniform3fv")) != 0L ? 1 : 0) & ((this.glProgramUniform4fv = GLContext.getFunctionAddress("glProgramUniform4fv")) != 0L ? 1 : 0) & ((this.glProgramUniform1dv = GLContext.getFunctionAddress("glProgramUniform1dv")) != 0L ? 1 : 0) & ((this.glProgramUniform2dv = GLContext.getFunctionAddress("glProgramUniform2dv")) != 0L ? 1 : 0) & ((this.glProgramUniform3dv = GLContext.getFunctionAddress("glProgramUniform3dv")) != 0L ? 1 : 0) & ((this.glProgramUniform4dv = GLContext.getFunctionAddress("glProgramUniform4dv")) != 0L ? 1 : 0) & ((this.glProgramUniform1ui = GLContext.getFunctionAddress("glProgramUniform1ui")) != 0L ? 1 : 0) & ((this.glProgramUniform2ui = GLContext.getFunctionAddress("glProgramUniform2ui")) != 0L ? 1 : 0) & ((this.glProgramUniform3ui = GLContext.getFunctionAddress("glProgramUniform3ui")) != 0L ? 1 : 0) & ((this.glProgramUniform4ui = GLContext.getFunctionAddress("glProgramUniform4ui")) != 0L ? 1 : 0) & ((this.glProgramUniform1uiv = GLContext.getFunctionAddress("glProgramUniform1uiv")) != 0L ? 1 : 0) & ((this.glProgramUniform2uiv = GLContext.getFunctionAddress("glProgramUniform2uiv")) != 0L ? 1 : 0) & ((this.glProgramUniform3uiv = GLContext.getFunctionAddress("glProgramUniform3uiv")) != 0L ? 1 : 0) & ((this.glProgramUniform4uiv = GLContext.getFunctionAddress("glProgramUniform4uiv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2fv = GLContext.getFunctionAddress("glProgramUniformMatrix2fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3fv = GLContext.getFunctionAddress("glProgramUniformMatrix3fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4fv = GLContext.getFunctionAddress("glProgramUniformMatrix4fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2dv = GLContext.getFunctionAddress("glProgramUniformMatrix2dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3dv = GLContext.getFunctionAddress("glProgramUniformMatrix3dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4dv = GLContext.getFunctionAddress("glProgramUniformMatrix4dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2x3fv = GLContext.getFunctionAddress("glProgramUniformMatrix2x3fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3x2fv = GLContext.getFunctionAddress("glProgramUniformMatrix3x2fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2x4fv = GLContext.getFunctionAddress("glProgramUniformMatrix2x4fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4x2fv = GLContext.getFunctionAddress("glProgramUniformMatrix4x2fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3x4fv = GLContext.getFunctionAddress("glProgramUniformMatrix3x4fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4x3fv = GLContext.getFunctionAddress("glProgramUniformMatrix4x3fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2x3dv = GLContext.getFunctionAddress("glProgramUniformMatrix2x3dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3x2dv = GLContext.getFunctionAddress("glProgramUniformMatrix3x2dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2x4dv = GLContext.getFunctionAddress("glProgramUniformMatrix2x4dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4x2dv = GLContext.getFunctionAddress("glProgramUniformMatrix4x2dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3x4dv = GLContext.getFunctionAddress("glProgramUniformMatrix3x4dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4x3dv = GLContext.getFunctionAddress("glProgramUniformMatrix4x3dv")) != 0L ? 1 : 0) & ((this.glValidateProgramPipeline = GLContext.getFunctionAddress("glValidateProgramPipeline")) != 0L ? 1 : 0) & ((this.glGetProgramPipelineInfoLog = GLContext.getFunctionAddress("glGetProgramPipelineInfoLog")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_shader_atomic_counters_initNativeFunctionAddresses()
/*      */   {
/* 2961 */     return (this.glGetActiveAtomicCounterBufferiv = GLContext.getFunctionAddress("glGetActiveAtomicCounterBufferiv")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_shader_image_load_store_initNativeFunctionAddresses()
/*      */   {
/* 2966 */     return ((this.glBindImageTexture = GLContext.getFunctionAddress("glBindImageTexture")) != 0L ? 1 : 0) & ((this.glMemoryBarrier = GLContext.getFunctionAddress("glMemoryBarrier")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_shader_objects_initNativeFunctionAddresses()
/*      */   {
/* 2972 */     return ((this.glDeleteObjectARB = GLContext.getFunctionAddress("glDeleteObjectARB")) != 0L ? 1 : 0) & ((this.glGetHandleARB = GLContext.getFunctionAddress("glGetHandleARB")) != 0L ? 1 : 0) & ((this.glDetachObjectARB = GLContext.getFunctionAddress("glDetachObjectARB")) != 0L ? 1 : 0) & ((this.glCreateShaderObjectARB = GLContext.getFunctionAddress("glCreateShaderObjectARB")) != 0L ? 1 : 0) & ((this.glShaderSourceARB = GLContext.getFunctionAddress("glShaderSourceARB")) != 0L ? 1 : 0) & ((this.glCompileShaderARB = GLContext.getFunctionAddress("glCompileShaderARB")) != 0L ? 1 : 0) & ((this.glCreateProgramObjectARB = GLContext.getFunctionAddress("glCreateProgramObjectARB")) != 0L ? 1 : 0) & ((this.glAttachObjectARB = GLContext.getFunctionAddress("glAttachObjectARB")) != 0L ? 1 : 0) & ((this.glLinkProgramARB = GLContext.getFunctionAddress("glLinkProgramARB")) != 0L ? 1 : 0) & ((this.glUseProgramObjectARB = GLContext.getFunctionAddress("glUseProgramObjectARB")) != 0L ? 1 : 0) & ((this.glValidateProgramARB = GLContext.getFunctionAddress("glValidateProgramARB")) != 0L ? 1 : 0) & ((this.glUniform1fARB = GLContext.getFunctionAddress("glUniform1fARB")) != 0L ? 1 : 0) & ((this.glUniform2fARB = GLContext.getFunctionAddress("glUniform2fARB")) != 0L ? 1 : 0) & ((this.glUniform3fARB = GLContext.getFunctionAddress("glUniform3fARB")) != 0L ? 1 : 0) & ((this.glUniform4fARB = GLContext.getFunctionAddress("glUniform4fARB")) != 0L ? 1 : 0) & ((this.glUniform1iARB = GLContext.getFunctionAddress("glUniform1iARB")) != 0L ? 1 : 0) & ((this.glUniform2iARB = GLContext.getFunctionAddress("glUniform2iARB")) != 0L ? 1 : 0) & ((this.glUniform3iARB = GLContext.getFunctionAddress("glUniform3iARB")) != 0L ? 1 : 0) & ((this.glUniform4iARB = GLContext.getFunctionAddress("glUniform4iARB")) != 0L ? 1 : 0) & ((this.glUniform1fvARB = GLContext.getFunctionAddress("glUniform1fvARB")) != 0L ? 1 : 0) & ((this.glUniform2fvARB = GLContext.getFunctionAddress("glUniform2fvARB")) != 0L ? 1 : 0) & ((this.glUniform3fvARB = GLContext.getFunctionAddress("glUniform3fvARB")) != 0L ? 1 : 0) & ((this.glUniform4fvARB = GLContext.getFunctionAddress("glUniform4fvARB")) != 0L ? 1 : 0) & ((this.glUniform1ivARB = GLContext.getFunctionAddress("glUniform1ivARB")) != 0L ? 1 : 0) & ((this.glUniform2ivARB = GLContext.getFunctionAddress("glUniform2ivARB")) != 0L ? 1 : 0) & ((this.glUniform3ivARB = GLContext.getFunctionAddress("glUniform3ivARB")) != 0L ? 1 : 0) & ((this.glUniform4ivARB = GLContext.getFunctionAddress("glUniform4ivARB")) != 0L ? 1 : 0) & ((this.glUniformMatrix2fvARB = GLContext.getFunctionAddress("glUniformMatrix2fvARB")) != 0L ? 1 : 0) & ((this.glUniformMatrix3fvARB = GLContext.getFunctionAddress("glUniformMatrix3fvARB")) != 0L ? 1 : 0) & ((this.glUniformMatrix4fvARB = GLContext.getFunctionAddress("glUniformMatrix4fvARB")) != 0L ? 1 : 0) & ((this.glGetObjectParameterfvARB = GLContext.getFunctionAddress("glGetObjectParameterfvARB")) != 0L ? 1 : 0) & ((this.glGetObjectParameterivARB = GLContext.getFunctionAddress("glGetObjectParameterivARB")) != 0L ? 1 : 0) & ((this.glGetInfoLogARB = GLContext.getFunctionAddress("glGetInfoLogARB")) != 0L ? 1 : 0) & ((this.glGetAttachedObjectsARB = GLContext.getFunctionAddress("glGetAttachedObjectsARB")) != 0L ? 1 : 0) & ((this.glGetUniformLocationARB = GLContext.getFunctionAddress("glGetUniformLocationARB")) != 0L ? 1 : 0) & ((this.glGetActiveUniformARB = GLContext.getFunctionAddress("glGetActiveUniformARB")) != 0L ? 1 : 0) & ((this.glGetUniformfvARB = GLContext.getFunctionAddress("glGetUniformfvARB")) != 0L ? 1 : 0) & ((this.glGetUniformivARB = GLContext.getFunctionAddress("glGetUniformivARB")) != 0L ? 1 : 0) & ((this.glGetShaderSourceARB = GLContext.getFunctionAddress("glGetShaderSourceARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_shader_storage_buffer_object_initNativeFunctionAddresses()
/*      */   {
/* 3015 */     return (this.glShaderStorageBlockBinding = GLContext.getFunctionAddress("glShaderStorageBlockBinding")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_shader_subroutine_initNativeFunctionAddresses()
/*      */   {
/* 3020 */     return ((this.glGetSubroutineUniformLocation = GLContext.getFunctionAddress("glGetSubroutineUniformLocation")) != 0L ? 1 : 0) & ((this.glGetSubroutineIndex = GLContext.getFunctionAddress("glGetSubroutineIndex")) != 0L ? 1 : 0) & ((this.glGetActiveSubroutineUniformiv = GLContext.getFunctionAddress("glGetActiveSubroutineUniformiv")) != 0L ? 1 : 0) & ((this.glGetActiveSubroutineUniformName = GLContext.getFunctionAddress("glGetActiveSubroutineUniformName")) != 0L ? 1 : 0) & ((this.glGetActiveSubroutineName = GLContext.getFunctionAddress("glGetActiveSubroutineName")) != 0L ? 1 : 0) & ((this.glUniformSubroutinesuiv = GLContext.getFunctionAddress("glUniformSubroutinesuiv")) != 0L ? 1 : 0) & ((this.glGetUniformSubroutineuiv = GLContext.getFunctionAddress("glGetUniformSubroutineuiv")) != 0L ? 1 : 0) & ((this.glGetProgramStageiv = GLContext.getFunctionAddress("glGetProgramStageiv")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_shading_language_include_initNativeFunctionAddresses()
/*      */   {
/* 3032 */     return ((this.glNamedStringARB = GLContext.getFunctionAddress("glNamedStringARB")) != 0L ? 1 : 0) & ((this.glDeleteNamedStringARB = GLContext.getFunctionAddress("glDeleteNamedStringARB")) != 0L ? 1 : 0) & ((this.glCompileShaderIncludeARB = GLContext.getFunctionAddress("glCompileShaderIncludeARB")) != 0L ? 1 : 0) & ((this.glIsNamedStringARB = GLContext.getFunctionAddress("glIsNamedStringARB")) != 0L ? 1 : 0) & ((this.glGetNamedStringARB = GLContext.getFunctionAddress("glGetNamedStringARB")) != 0L ? 1 : 0) & ((this.glGetNamedStringivARB = GLContext.getFunctionAddress("glGetNamedStringivARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_sync_initNativeFunctionAddresses()
/*      */   {
/* 3042 */     return ((this.glFenceSync = GLContext.getFunctionAddress("glFenceSync")) != 0L ? 1 : 0) & ((this.glIsSync = GLContext.getFunctionAddress("glIsSync")) != 0L ? 1 : 0) & ((this.glDeleteSync = GLContext.getFunctionAddress("glDeleteSync")) != 0L ? 1 : 0) & ((this.glClientWaitSync = GLContext.getFunctionAddress("glClientWaitSync")) != 0L ? 1 : 0) & ((this.glWaitSync = GLContext.getFunctionAddress("glWaitSync")) != 0L ? 1 : 0) & ((this.glGetInteger64v = GLContext.getFunctionAddress("glGetInteger64v")) != 0L ? 1 : 0) & ((this.glGetSynciv = GLContext.getFunctionAddress("glGetSynciv")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_tessellation_shader_initNativeFunctionAddresses()
/*      */   {
/* 3053 */     return ((this.glPatchParameteri = GLContext.getFunctionAddress("glPatchParameteri")) != 0L ? 1 : 0) & ((this.glPatchParameterfv = GLContext.getFunctionAddress("glPatchParameterfv")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_texture_buffer_object_initNativeFunctionAddresses()
/*      */   {
/* 3059 */     return (this.glTexBufferARB = GLContext.getFunctionAddress("glTexBufferARB")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_texture_buffer_range_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 3064 */     return ((this.glTexBufferRange = GLContext.getFunctionAddress("glTexBufferRange")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glTextureBufferRangeEXT = GLContext.getFunctionAddress("glTextureBufferRangeEXT")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_texture_compression_initNativeFunctionAddresses()
/*      */   {
/* 3070 */     return ((this.glCompressedTexImage1DARB = GLContext.getFunctionAddress("glCompressedTexImage1DARB")) != 0L ? 1 : 0) & ((this.glCompressedTexImage2DARB = GLContext.getFunctionAddress("glCompressedTexImage2DARB")) != 0L ? 1 : 0) & ((this.glCompressedTexImage3DARB = GLContext.getFunctionAddress("glCompressedTexImage3DARB")) != 0L ? 1 : 0) & ((this.glCompressedTexSubImage1DARB = GLContext.getFunctionAddress("glCompressedTexSubImage1DARB")) != 0L ? 1 : 0) & ((this.glCompressedTexSubImage2DARB = GLContext.getFunctionAddress("glCompressedTexSubImage2DARB")) != 0L ? 1 : 0) & ((this.glCompressedTexSubImage3DARB = GLContext.getFunctionAddress("glCompressedTexSubImage3DARB")) != 0L ? 1 : 0) & ((this.glGetCompressedTexImageARB = GLContext.getFunctionAddress("glGetCompressedTexImageARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_texture_multisample_initNativeFunctionAddresses()
/*      */   {
/* 3081 */     return ((this.glTexImage2DMultisample = GLContext.getFunctionAddress("glTexImage2DMultisample")) != 0L ? 1 : 0) & ((this.glTexImage3DMultisample = GLContext.getFunctionAddress("glTexImage3DMultisample")) != 0L ? 1 : 0) & ((this.glGetMultisamplefv = GLContext.getFunctionAddress("glGetMultisamplefv")) != 0L ? 1 : 0) & ((this.glSampleMaski = GLContext.getFunctionAddress("glSampleMaski")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_texture_storage_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 3089 */     if (supported_extensions.contains("GL_EXT_direct_state_access"));
/* 3089 */     if (supported_extensions.contains("GL_EXT_direct_state_access"));
/* 3089 */     if (supported_extensions.contains("GL_EXT_direct_state_access"));
/* 3089 */     return ((this.glTexStorage1D = GLContext.getFunctionAddress(new String[] { "glTexStorage1D", "glTexStorage1DEXT" })) != 0L ? 1 : 0) & ((this.glTexStorage2D = GLContext.getFunctionAddress(new String[] { "glTexStorage2D", "glTexStorage2DEXT" })) != 0L ? 1 : 0) & ((this.glTexStorage3D = GLContext.getFunctionAddress(new String[] { "glTexStorage3D", "glTexStorage3DEXT" })) != 0L ? 1 : 0) & ((this.glTextureStorage1DEXT = GLContext.getFunctionAddress(new String[] { "glTextureStorage1DEXT", "glTextureStorage1DEXTEXT" })) != 0L ? 1 : 0) & ((this.glTextureStorage2DEXT = GLContext.getFunctionAddress(new String[] { "glTextureStorage2DEXT", "glTextureStorage2DEXTEXT" })) != 0L ? 1 : 0) & ((this.glTextureStorage3DEXT = GLContext.getFunctionAddress(new String[] { "glTextureStorage3DEXT", "glTextureStorage3DEXTEXT" })) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_texture_storage_multisample_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 3099 */     return ((this.glTexStorage2DMultisample = GLContext.getFunctionAddress("glTexStorage2DMultisample")) != 0L ? 1 : 0) & ((this.glTexStorage3DMultisample = GLContext.getFunctionAddress("glTexStorage3DMultisample")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glTextureStorage2DMultisampleEXT = GLContext.getFunctionAddress("glTextureStorage2DMultisampleEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glTextureStorage3DMultisampleEXT = GLContext.getFunctionAddress("glTextureStorage3DMultisampleEXT")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_texture_view_initNativeFunctionAddresses()
/*      */   {
/* 3107 */     return (this.glTextureView = GLContext.getFunctionAddress("glTextureView")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ARB_timer_query_initNativeFunctionAddresses()
/*      */   {
/* 3112 */     return ((this.glQueryCounter = GLContext.getFunctionAddress("glQueryCounter")) != 0L ? 1 : 0) & ((this.glGetQueryObjecti64v = GLContext.getFunctionAddress("glGetQueryObjecti64v")) != 0L ? 1 : 0) & ((this.glGetQueryObjectui64v = GLContext.getFunctionAddress("glGetQueryObjectui64v")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_transform_feedback2_initNativeFunctionAddresses()
/*      */   {
/* 3119 */     return ((this.glBindTransformFeedback = GLContext.getFunctionAddress("glBindTransformFeedback")) != 0L ? 1 : 0) & ((this.glDeleteTransformFeedbacks = GLContext.getFunctionAddress("glDeleteTransformFeedbacks")) != 0L ? 1 : 0) & ((this.glGenTransformFeedbacks = GLContext.getFunctionAddress("glGenTransformFeedbacks")) != 0L ? 1 : 0) & ((this.glIsTransformFeedback = GLContext.getFunctionAddress("glIsTransformFeedback")) != 0L ? 1 : 0) & ((this.glPauseTransformFeedback = GLContext.getFunctionAddress("glPauseTransformFeedback")) != 0L ? 1 : 0) & ((this.glResumeTransformFeedback = GLContext.getFunctionAddress("glResumeTransformFeedback")) != 0L ? 1 : 0) & ((this.glDrawTransformFeedback = GLContext.getFunctionAddress("glDrawTransformFeedback")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_transform_feedback3_initNativeFunctionAddresses()
/*      */   {
/* 3130 */     return ((this.glDrawTransformFeedbackStream = GLContext.getFunctionAddress("glDrawTransformFeedbackStream")) != 0L ? 1 : 0) & ((this.glBeginQueryIndexed = GLContext.getFunctionAddress("glBeginQueryIndexed")) != 0L ? 1 : 0) & ((this.glEndQueryIndexed = GLContext.getFunctionAddress("glEndQueryIndexed")) != 0L ? 1 : 0) & ((this.glGetQueryIndexediv = GLContext.getFunctionAddress("glGetQueryIndexediv")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_transform_feedback_instanced_initNativeFunctionAddresses()
/*      */   {
/* 3138 */     return ((this.glDrawTransformFeedbackInstanced = GLContext.getFunctionAddress("glDrawTransformFeedbackInstanced")) != 0L ? 1 : 0) & ((this.glDrawTransformFeedbackStreamInstanced = GLContext.getFunctionAddress("glDrawTransformFeedbackStreamInstanced")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_transpose_matrix_initNativeFunctionAddresses()
/*      */   {
/* 3144 */     return ((this.glLoadTransposeMatrixfARB = GLContext.getFunctionAddress("glLoadTransposeMatrixfARB")) != 0L ? 1 : 0) & ((this.glMultTransposeMatrixfARB = GLContext.getFunctionAddress("glMultTransposeMatrixfARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_uniform_buffer_object_initNativeFunctionAddresses()
/*      */   {
/* 3150 */     return ((this.glGetUniformIndices = GLContext.getFunctionAddress("glGetUniformIndices")) != 0L ? 1 : 0) & ((this.glGetActiveUniformsiv = GLContext.getFunctionAddress("glGetActiveUniformsiv")) != 0L ? 1 : 0) & ((this.glGetActiveUniformName = GLContext.getFunctionAddress("glGetActiveUniformName")) != 0L ? 1 : 0) & ((this.glGetUniformBlockIndex = GLContext.getFunctionAddress("glGetUniformBlockIndex")) != 0L ? 1 : 0) & ((this.glGetActiveUniformBlockiv = GLContext.getFunctionAddress("glGetActiveUniformBlockiv")) != 0L ? 1 : 0) & ((this.glGetActiveUniformBlockName = GLContext.getFunctionAddress("glGetActiveUniformBlockName")) != 0L ? 1 : 0) & ((this.glBindBufferRange = GLContext.getFunctionAddress("glBindBufferRange")) != 0L ? 1 : 0) & ((this.glBindBufferBase = GLContext.getFunctionAddress("glBindBufferBase")) != 0L ? 1 : 0) & ((this.glGetIntegeri_v = GLContext.getFunctionAddress("glGetIntegeri_v")) != 0L ? 1 : 0) & ((this.glUniformBlockBinding = GLContext.getFunctionAddress("glUniformBlockBinding")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_vertex_array_object_initNativeFunctionAddresses()
/*      */   {
/* 3164 */     return ((this.glBindVertexArray = GLContext.getFunctionAddress("glBindVertexArray")) != 0L ? 1 : 0) & ((this.glDeleteVertexArrays = GLContext.getFunctionAddress("glDeleteVertexArrays")) != 0L ? 1 : 0) & ((this.glGenVertexArrays = GLContext.getFunctionAddress("glGenVertexArrays")) != 0L ? 1 : 0) & ((this.glIsVertexArray = GLContext.getFunctionAddress("glIsVertexArray")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_vertex_attrib_64bit_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 3172 */     return ((this.glVertexAttribL1d = GLContext.getFunctionAddress("glVertexAttribL1d")) != 0L ? 1 : 0) & ((this.glVertexAttribL2d = GLContext.getFunctionAddress("glVertexAttribL2d")) != 0L ? 1 : 0) & ((this.glVertexAttribL3d = GLContext.getFunctionAddress("glVertexAttribL3d")) != 0L ? 1 : 0) & ((this.glVertexAttribL4d = GLContext.getFunctionAddress("glVertexAttribL4d")) != 0L ? 1 : 0) & ((this.glVertexAttribL1dv = GLContext.getFunctionAddress("glVertexAttribL1dv")) != 0L ? 1 : 0) & ((this.glVertexAttribL2dv = GLContext.getFunctionAddress("glVertexAttribL2dv")) != 0L ? 1 : 0) & ((this.glVertexAttribL3dv = GLContext.getFunctionAddress("glVertexAttribL3dv")) != 0L ? 1 : 0) & ((this.glVertexAttribL4dv = GLContext.getFunctionAddress("glVertexAttribL4dv")) != 0L ? 1 : 0) & ((this.glVertexAttribLPointer = GLContext.getFunctionAddress("glVertexAttribLPointer")) != 0L ? 1 : 0) & ((this.glGetVertexAttribLdv = GLContext.getFunctionAddress("glGetVertexAttribLdv")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glVertexArrayVertexAttribLOffsetEXT = GLContext.getFunctionAddress("glVertexArrayVertexAttribLOffsetEXT")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_vertex_attrib_binding_initNativeFunctionAddresses()
/*      */   {
/* 3187 */     return ((this.glBindVertexBuffer = GLContext.getFunctionAddress("glBindVertexBuffer")) != 0L ? 1 : 0) & ((this.glVertexAttribFormat = GLContext.getFunctionAddress("glVertexAttribFormat")) != 0L ? 1 : 0) & ((this.glVertexAttribIFormat = GLContext.getFunctionAddress("glVertexAttribIFormat")) != 0L ? 1 : 0) & ((this.glVertexAttribLFormat = GLContext.getFunctionAddress("glVertexAttribLFormat")) != 0L ? 1 : 0) & ((this.glVertexAttribBinding = GLContext.getFunctionAddress("glVertexAttribBinding")) != 0L ? 1 : 0) & ((this.glVertexBindingDivisor = GLContext.getFunctionAddress("glVertexBindingDivisor")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_vertex_blend_initNativeFunctionAddresses()
/*      */   {
/* 3197 */     return ((this.glWeightbvARB = GLContext.getFunctionAddress("glWeightbvARB")) != 0L ? 1 : 0) & ((this.glWeightsvARB = GLContext.getFunctionAddress("glWeightsvARB")) != 0L ? 1 : 0) & ((this.glWeightivARB = GLContext.getFunctionAddress("glWeightivARB")) != 0L ? 1 : 0) & ((this.glWeightfvARB = GLContext.getFunctionAddress("glWeightfvARB")) != 0L ? 1 : 0) & ((this.glWeightdvARB = GLContext.getFunctionAddress("glWeightdvARB")) != 0L ? 1 : 0) & ((this.glWeightubvARB = GLContext.getFunctionAddress("glWeightubvARB")) != 0L ? 1 : 0) & ((this.glWeightusvARB = GLContext.getFunctionAddress("glWeightusvARB")) != 0L ? 1 : 0) & ((this.glWeightuivARB = GLContext.getFunctionAddress("glWeightuivARB")) != 0L ? 1 : 0) & ((this.glWeightPointerARB = GLContext.getFunctionAddress("glWeightPointerARB")) != 0L ? 1 : 0) & ((this.glVertexBlendARB = GLContext.getFunctionAddress("glVertexBlendARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_vertex_program_initNativeFunctionAddresses()
/*      */   {
/* 3211 */     return ((this.glVertexAttrib1sARB = GLContext.getFunctionAddress("glVertexAttrib1sARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib1fARB = GLContext.getFunctionAddress("glVertexAttrib1fARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib1dARB = GLContext.getFunctionAddress("glVertexAttrib1dARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib2sARB = GLContext.getFunctionAddress("glVertexAttrib2sARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib2fARB = GLContext.getFunctionAddress("glVertexAttrib2fARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib2dARB = GLContext.getFunctionAddress("glVertexAttrib2dARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib3sARB = GLContext.getFunctionAddress("glVertexAttrib3sARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib3fARB = GLContext.getFunctionAddress("glVertexAttrib3fARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib3dARB = GLContext.getFunctionAddress("glVertexAttrib3dARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib4sARB = GLContext.getFunctionAddress("glVertexAttrib4sARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib4fARB = GLContext.getFunctionAddress("glVertexAttrib4fARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib4dARB = GLContext.getFunctionAddress("glVertexAttrib4dARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib4NubARB = GLContext.getFunctionAddress("glVertexAttrib4NubARB")) != 0L ? 1 : 0) & ((this.glVertexAttribPointerARB = GLContext.getFunctionAddress("glVertexAttribPointerARB")) != 0L ? 1 : 0) & ((this.glEnableVertexAttribArrayARB = GLContext.getFunctionAddress("glEnableVertexAttribArrayARB")) != 0L ? 1 : 0) & ((this.glDisableVertexAttribArrayARB = GLContext.getFunctionAddress("glDisableVertexAttribArrayARB")) != 0L ? 1 : 0) & ((this.glGetVertexAttribfvARB = GLContext.getFunctionAddress("glGetVertexAttribfvARB")) != 0L ? 1 : 0) & ((this.glGetVertexAttribdvARB = GLContext.getFunctionAddress("glGetVertexAttribdvARB")) != 0L ? 1 : 0) & ((this.glGetVertexAttribivARB = GLContext.getFunctionAddress("glGetVertexAttribivARB")) != 0L ? 1 : 0) & ((this.glGetVertexAttribPointervARB = GLContext.getFunctionAddress("glGetVertexAttribPointervARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_vertex_shader_initNativeFunctionAddresses()
/*      */   {
/* 3235 */     return ((this.glVertexAttrib1sARB = GLContext.getFunctionAddress("glVertexAttrib1sARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib1fARB = GLContext.getFunctionAddress("glVertexAttrib1fARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib1dARB = GLContext.getFunctionAddress("glVertexAttrib1dARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib2sARB = GLContext.getFunctionAddress("glVertexAttrib2sARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib2fARB = GLContext.getFunctionAddress("glVertexAttrib2fARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib2dARB = GLContext.getFunctionAddress("glVertexAttrib2dARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib3sARB = GLContext.getFunctionAddress("glVertexAttrib3sARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib3fARB = GLContext.getFunctionAddress("glVertexAttrib3fARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib3dARB = GLContext.getFunctionAddress("glVertexAttrib3dARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib4sARB = GLContext.getFunctionAddress("glVertexAttrib4sARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib4fARB = GLContext.getFunctionAddress("glVertexAttrib4fARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib4dARB = GLContext.getFunctionAddress("glVertexAttrib4dARB")) != 0L ? 1 : 0) & ((this.glVertexAttrib4NubARB = GLContext.getFunctionAddress("glVertexAttrib4NubARB")) != 0L ? 1 : 0) & ((this.glVertexAttribPointerARB = GLContext.getFunctionAddress("glVertexAttribPointerARB")) != 0L ? 1 : 0) & ((this.glEnableVertexAttribArrayARB = GLContext.getFunctionAddress("glEnableVertexAttribArrayARB")) != 0L ? 1 : 0) & ((this.glDisableVertexAttribArrayARB = GLContext.getFunctionAddress("glDisableVertexAttribArrayARB")) != 0L ? 1 : 0) & ((this.glBindAttribLocationARB = GLContext.getFunctionAddress("glBindAttribLocationARB")) != 0L ? 1 : 0) & ((this.glGetActiveAttribARB = GLContext.getFunctionAddress("glGetActiveAttribARB")) != 0L ? 1 : 0) & ((this.glGetAttribLocationARB = GLContext.getFunctionAddress("glGetAttribLocationARB")) != 0L ? 1 : 0) & ((this.glGetVertexAttribfvARB = GLContext.getFunctionAddress("glGetVertexAttribfvARB")) != 0L ? 1 : 0) & ((this.glGetVertexAttribdvARB = GLContext.getFunctionAddress("glGetVertexAttribdvARB")) != 0L ? 1 : 0) & ((this.glGetVertexAttribivARB = GLContext.getFunctionAddress("glGetVertexAttribivARB")) != 0L ? 1 : 0) & ((this.glGetVertexAttribPointervARB = GLContext.getFunctionAddress("glGetVertexAttribPointervARB")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_vertex_type_2_10_10_10_rev_initNativeFunctionAddresses()
/*      */   {
/* 3262 */     return ((this.glVertexP2ui = GLContext.getFunctionAddress("glVertexP2ui")) != 0L ? 1 : 0) & ((this.glVertexP3ui = GLContext.getFunctionAddress("glVertexP3ui")) != 0L ? 1 : 0) & ((this.glVertexP4ui = GLContext.getFunctionAddress("glVertexP4ui")) != 0L ? 1 : 0) & ((this.glVertexP2uiv = GLContext.getFunctionAddress("glVertexP2uiv")) != 0L ? 1 : 0) & ((this.glVertexP3uiv = GLContext.getFunctionAddress("glVertexP3uiv")) != 0L ? 1 : 0) & ((this.glVertexP4uiv = GLContext.getFunctionAddress("glVertexP4uiv")) != 0L ? 1 : 0) & ((this.glTexCoordP1ui = GLContext.getFunctionAddress("glTexCoordP1ui")) != 0L ? 1 : 0) & ((this.glTexCoordP2ui = GLContext.getFunctionAddress("glTexCoordP2ui")) != 0L ? 1 : 0) & ((this.glTexCoordP3ui = GLContext.getFunctionAddress("glTexCoordP3ui")) != 0L ? 1 : 0) & ((this.glTexCoordP4ui = GLContext.getFunctionAddress("glTexCoordP4ui")) != 0L ? 1 : 0) & ((this.glTexCoordP1uiv = GLContext.getFunctionAddress("glTexCoordP1uiv")) != 0L ? 1 : 0) & ((this.glTexCoordP2uiv = GLContext.getFunctionAddress("glTexCoordP2uiv")) != 0L ? 1 : 0) & ((this.glTexCoordP3uiv = GLContext.getFunctionAddress("glTexCoordP3uiv")) != 0L ? 1 : 0) & ((this.glTexCoordP4uiv = GLContext.getFunctionAddress("glTexCoordP4uiv")) != 0L ? 1 : 0) & ((this.glMultiTexCoordP1ui = GLContext.getFunctionAddress("glMultiTexCoordP1ui")) != 0L ? 1 : 0) & ((this.glMultiTexCoordP2ui = GLContext.getFunctionAddress("glMultiTexCoordP2ui")) != 0L ? 1 : 0) & ((this.glMultiTexCoordP3ui = GLContext.getFunctionAddress("glMultiTexCoordP3ui")) != 0L ? 1 : 0) & ((this.glMultiTexCoordP4ui = GLContext.getFunctionAddress("glMultiTexCoordP4ui")) != 0L ? 1 : 0) & ((this.glMultiTexCoordP1uiv = GLContext.getFunctionAddress("glMultiTexCoordP1uiv")) != 0L ? 1 : 0) & ((this.glMultiTexCoordP2uiv = GLContext.getFunctionAddress("glMultiTexCoordP2uiv")) != 0L ? 1 : 0) & ((this.glMultiTexCoordP3uiv = GLContext.getFunctionAddress("glMultiTexCoordP3uiv")) != 0L ? 1 : 0) & ((this.glMultiTexCoordP4uiv = GLContext.getFunctionAddress("glMultiTexCoordP4uiv")) != 0L ? 1 : 0) & ((this.glNormalP3ui = GLContext.getFunctionAddress("glNormalP3ui")) != 0L ? 1 : 0) & ((this.glNormalP3uiv = GLContext.getFunctionAddress("glNormalP3uiv")) != 0L ? 1 : 0) & ((this.glColorP3ui = GLContext.getFunctionAddress("glColorP3ui")) != 0L ? 1 : 0) & ((this.glColorP4ui = GLContext.getFunctionAddress("glColorP4ui")) != 0L ? 1 : 0) & ((this.glColorP3uiv = GLContext.getFunctionAddress("glColorP3uiv")) != 0L ? 1 : 0) & ((this.glColorP4uiv = GLContext.getFunctionAddress("glColorP4uiv")) != 0L ? 1 : 0) & ((this.glSecondaryColorP3ui = GLContext.getFunctionAddress("glSecondaryColorP3ui")) != 0L ? 1 : 0) & ((this.glSecondaryColorP3uiv = GLContext.getFunctionAddress("glSecondaryColorP3uiv")) != 0L ? 1 : 0) & ((this.glVertexAttribP1ui = GLContext.getFunctionAddress("glVertexAttribP1ui")) != 0L ? 1 : 0) & ((this.glVertexAttribP2ui = GLContext.getFunctionAddress("glVertexAttribP2ui")) != 0L ? 1 : 0) & ((this.glVertexAttribP3ui = GLContext.getFunctionAddress("glVertexAttribP3ui")) != 0L ? 1 : 0) & ((this.glVertexAttribP4ui = GLContext.getFunctionAddress("glVertexAttribP4ui")) != 0L ? 1 : 0) & ((this.glVertexAttribP1uiv = GLContext.getFunctionAddress("glVertexAttribP1uiv")) != 0L ? 1 : 0) & ((this.glVertexAttribP2uiv = GLContext.getFunctionAddress("glVertexAttribP2uiv")) != 0L ? 1 : 0) & ((this.glVertexAttribP3uiv = GLContext.getFunctionAddress("glVertexAttribP3uiv")) != 0L ? 1 : 0) & ((this.glVertexAttribP4uiv = GLContext.getFunctionAddress("glVertexAttribP4uiv")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_viewport_array_initNativeFunctionAddresses()
/*      */   {
/* 3304 */     return ((this.glViewportArrayv = GLContext.getFunctionAddress("glViewportArrayv")) != 0L ? 1 : 0) & ((this.glViewportIndexedf = GLContext.getFunctionAddress("glViewportIndexedf")) != 0L ? 1 : 0) & ((this.glViewportIndexedfv = GLContext.getFunctionAddress("glViewportIndexedfv")) != 0L ? 1 : 0) & ((this.glScissorArrayv = GLContext.getFunctionAddress("glScissorArrayv")) != 0L ? 1 : 0) & ((this.glScissorIndexed = GLContext.getFunctionAddress("glScissorIndexed")) != 0L ? 1 : 0) & ((this.glScissorIndexedv = GLContext.getFunctionAddress("glScissorIndexedv")) != 0L ? 1 : 0) & ((this.glDepthRangeArrayv = GLContext.getFunctionAddress("glDepthRangeArrayv")) != 0L ? 1 : 0) & ((this.glDepthRangeIndexed = GLContext.getFunctionAddress("glDepthRangeIndexed")) != 0L ? 1 : 0) & ((this.glGetFloati_v = GLContext.getFunctionAddress("glGetFloati_v")) != 0L ? 1 : 0) & ((this.glGetDoublei_v = GLContext.getFunctionAddress("glGetDoublei_v")) != 0L ? 1 : 0) & ((this.glGetIntegerIndexedvEXT = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT")) != 0L ? 1 : 0) & ((this.glEnableIndexedEXT = GLContext.getFunctionAddress("glEnableIndexedEXT")) != 0L ? 1 : 0) & ((this.glDisableIndexedEXT = GLContext.getFunctionAddress("glDisableIndexedEXT")) != 0L ? 1 : 0) & ((this.glIsEnabledIndexedEXT = GLContext.getFunctionAddress("glIsEnabledIndexedEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ARB_window_pos_initNativeFunctionAddresses(boolean forwardCompatible)
/*      */   {
/* 3322 */     return ((forwardCompatible) || ((this.glWindowPos2fARB = GLContext.getFunctionAddress("glWindowPos2fARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos2dARB = GLContext.getFunctionAddress("glWindowPos2dARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos2iARB = GLContext.getFunctionAddress("glWindowPos2iARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos2sARB = GLContext.getFunctionAddress("glWindowPos2sARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos3fARB = GLContext.getFunctionAddress("glWindowPos3fARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos3dARB = GLContext.getFunctionAddress("glWindowPos3dARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos3iARB = GLContext.getFunctionAddress("glWindowPos3iARB")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos3sARB = GLContext.getFunctionAddress("glWindowPos3sARB")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ATI_draw_buffers_initNativeFunctionAddresses()
/*      */   {
/* 3334 */     return (this.glDrawBuffersATI = GLContext.getFunctionAddress("glDrawBuffersATI")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean ATI_element_array_initNativeFunctionAddresses()
/*      */   {
/* 3339 */     return ((this.glElementPointerATI = GLContext.getFunctionAddress("glElementPointerATI")) != 0L ? 1 : 0) & ((this.glDrawElementArrayATI = GLContext.getFunctionAddress("glDrawElementArrayATI")) != 0L ? 1 : 0) & ((this.glDrawRangeElementArrayATI = GLContext.getFunctionAddress("glDrawRangeElementArrayATI")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ATI_envmap_bumpmap_initNativeFunctionAddresses()
/*      */   {
/* 3346 */     return ((this.glTexBumpParameterfvATI = GLContext.getFunctionAddress("glTexBumpParameterfvATI")) != 0L ? 1 : 0) & ((this.glTexBumpParameterivATI = GLContext.getFunctionAddress("glTexBumpParameterivATI")) != 0L ? 1 : 0) & ((this.glGetTexBumpParameterfvATI = GLContext.getFunctionAddress("glGetTexBumpParameterfvATI")) != 0L ? 1 : 0) & ((this.glGetTexBumpParameterivATI = GLContext.getFunctionAddress("glGetTexBumpParameterivATI")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ATI_fragment_shader_initNativeFunctionAddresses()
/*      */   {
/* 3354 */     return ((this.glGenFragmentShadersATI = GLContext.getFunctionAddress("glGenFragmentShadersATI")) != 0L ? 1 : 0) & ((this.glBindFragmentShaderATI = GLContext.getFunctionAddress("glBindFragmentShaderATI")) != 0L ? 1 : 0) & ((this.glDeleteFragmentShaderATI = GLContext.getFunctionAddress("glDeleteFragmentShaderATI")) != 0L ? 1 : 0) & ((this.glBeginFragmentShaderATI = GLContext.getFunctionAddress("glBeginFragmentShaderATI")) != 0L ? 1 : 0) & ((this.glEndFragmentShaderATI = GLContext.getFunctionAddress("glEndFragmentShaderATI")) != 0L ? 1 : 0) & ((this.glPassTexCoordATI = GLContext.getFunctionAddress("glPassTexCoordATI")) != 0L ? 1 : 0) & ((this.glSampleMapATI = GLContext.getFunctionAddress("glSampleMapATI")) != 0L ? 1 : 0) & ((this.glColorFragmentOp1ATI = GLContext.getFunctionAddress("glColorFragmentOp1ATI")) != 0L ? 1 : 0) & ((this.glColorFragmentOp2ATI = GLContext.getFunctionAddress("glColorFragmentOp2ATI")) != 0L ? 1 : 0) & ((this.glColorFragmentOp3ATI = GLContext.getFunctionAddress("glColorFragmentOp3ATI")) != 0L ? 1 : 0) & ((this.glAlphaFragmentOp1ATI = GLContext.getFunctionAddress("glAlphaFragmentOp1ATI")) != 0L ? 1 : 0) & ((this.glAlphaFragmentOp2ATI = GLContext.getFunctionAddress("glAlphaFragmentOp2ATI")) != 0L ? 1 : 0) & ((this.glAlphaFragmentOp3ATI = GLContext.getFunctionAddress("glAlphaFragmentOp3ATI")) != 0L ? 1 : 0) & ((this.glSetFragmentShaderConstantATI = GLContext.getFunctionAddress("glSetFragmentShaderConstantATI")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ATI_map_object_buffer_initNativeFunctionAddresses()
/*      */   {
/* 3372 */     return ((this.glMapObjectBufferATI = GLContext.getFunctionAddress("glMapObjectBufferATI")) != 0L ? 1 : 0) & ((this.glUnmapObjectBufferATI = GLContext.getFunctionAddress("glUnmapObjectBufferATI")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ATI_pn_triangles_initNativeFunctionAddresses()
/*      */   {
/* 3378 */     return ((this.glPNTrianglesfATI = GLContext.getFunctionAddress("glPNTrianglesfATI")) != 0L ? 1 : 0) & ((this.glPNTrianglesiATI = GLContext.getFunctionAddress("glPNTrianglesiATI")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ATI_separate_stencil_initNativeFunctionAddresses()
/*      */   {
/* 3384 */     return ((this.glStencilOpSeparateATI = GLContext.getFunctionAddress("glStencilOpSeparateATI")) != 0L ? 1 : 0) & ((this.glStencilFuncSeparateATI = GLContext.getFunctionAddress("glStencilFuncSeparateATI")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ATI_vertex_array_object_initNativeFunctionAddresses()
/*      */   {
/* 3390 */     return ((this.glNewObjectBufferATI = GLContext.getFunctionAddress("glNewObjectBufferATI")) != 0L ? 1 : 0) & ((this.glIsObjectBufferATI = GLContext.getFunctionAddress("glIsObjectBufferATI")) != 0L ? 1 : 0) & ((this.glUpdateObjectBufferATI = GLContext.getFunctionAddress("glUpdateObjectBufferATI")) != 0L ? 1 : 0) & ((this.glGetObjectBufferfvATI = GLContext.getFunctionAddress("glGetObjectBufferfvATI")) != 0L ? 1 : 0) & ((this.glGetObjectBufferivATI = GLContext.getFunctionAddress("glGetObjectBufferivATI")) != 0L ? 1 : 0) & ((this.glFreeObjectBufferATI = GLContext.getFunctionAddress("glFreeObjectBufferATI")) != 0L ? 1 : 0) & ((this.glArrayObjectATI = GLContext.getFunctionAddress("glArrayObjectATI")) != 0L ? 1 : 0) & ((this.glGetArrayObjectfvATI = GLContext.getFunctionAddress("glGetArrayObjectfvATI")) != 0L ? 1 : 0) & ((this.glGetArrayObjectivATI = GLContext.getFunctionAddress("glGetArrayObjectivATI")) != 0L ? 1 : 0) & ((this.glVariantArrayObjectATI = GLContext.getFunctionAddress("glVariantArrayObjectATI")) != 0L ? 1 : 0) & ((this.glGetVariantArrayObjectfvATI = GLContext.getFunctionAddress("glGetVariantArrayObjectfvATI")) != 0L ? 1 : 0) & ((this.glGetVariantArrayObjectivATI = GLContext.getFunctionAddress("glGetVariantArrayObjectivATI")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ATI_vertex_attrib_array_object_initNativeFunctionAddresses()
/*      */   {
/* 3406 */     return ((this.glVertexAttribArrayObjectATI = GLContext.getFunctionAddress("glVertexAttribArrayObjectATI")) != 0L ? 1 : 0) & ((this.glGetVertexAttribArrayObjectfvATI = GLContext.getFunctionAddress("glGetVertexAttribArrayObjectfvATI")) != 0L ? 1 : 0) & ((this.glGetVertexAttribArrayObjectivATI = GLContext.getFunctionAddress("glGetVertexAttribArrayObjectivATI")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean ATI_vertex_streams_initNativeFunctionAddresses()
/*      */   {
/* 3413 */     return ((this.glVertexStream2fATI = GLContext.getFunctionAddress("glVertexStream2fATI")) != 0L ? 1 : 0) & ((this.glVertexStream2dATI = GLContext.getFunctionAddress("glVertexStream2dATI")) != 0L ? 1 : 0) & ((this.glVertexStream2iATI = GLContext.getFunctionAddress("glVertexStream2iATI")) != 0L ? 1 : 0) & ((this.glVertexStream2sATI = GLContext.getFunctionAddress("glVertexStream2sATI")) != 0L ? 1 : 0) & ((this.glVertexStream3fATI = GLContext.getFunctionAddress("glVertexStream3fATI")) != 0L ? 1 : 0) & ((this.glVertexStream3dATI = GLContext.getFunctionAddress("glVertexStream3dATI")) != 0L ? 1 : 0) & ((this.glVertexStream3iATI = GLContext.getFunctionAddress("glVertexStream3iATI")) != 0L ? 1 : 0) & ((this.glVertexStream3sATI = GLContext.getFunctionAddress("glVertexStream3sATI")) != 0L ? 1 : 0) & ((this.glVertexStream4fATI = GLContext.getFunctionAddress("glVertexStream4fATI")) != 0L ? 1 : 0) & ((this.glVertexStream4dATI = GLContext.getFunctionAddress("glVertexStream4dATI")) != 0L ? 1 : 0) & ((this.glVertexStream4iATI = GLContext.getFunctionAddress("glVertexStream4iATI")) != 0L ? 1 : 0) & ((this.glVertexStream4sATI = GLContext.getFunctionAddress("glVertexStream4sATI")) != 0L ? 1 : 0) & ((this.glNormalStream3bATI = GLContext.getFunctionAddress("glNormalStream3bATI")) != 0L ? 1 : 0) & ((this.glNormalStream3fATI = GLContext.getFunctionAddress("glNormalStream3fATI")) != 0L ? 1 : 0) & ((this.glNormalStream3dATI = GLContext.getFunctionAddress("glNormalStream3dATI")) != 0L ? 1 : 0) & ((this.glNormalStream3iATI = GLContext.getFunctionAddress("glNormalStream3iATI")) != 0L ? 1 : 0) & ((this.glNormalStream3sATI = GLContext.getFunctionAddress("glNormalStream3sATI")) != 0L ? 1 : 0) & ((this.glClientActiveVertexStreamATI = GLContext.getFunctionAddress("glClientActiveVertexStreamATI")) != 0L ? 1 : 0) & ((this.glVertexBlendEnvfATI = GLContext.getFunctionAddress("glVertexBlendEnvfATI")) != 0L ? 1 : 0) & ((this.glVertexBlendEnviATI = GLContext.getFunctionAddress("glVertexBlendEnviATI")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_bindable_uniform_initNativeFunctionAddresses()
/*      */   {
/* 3437 */     return ((this.glUniformBufferEXT = GLContext.getFunctionAddress("glUniformBufferEXT")) != 0L ? 1 : 0) & ((this.glGetUniformBufferSizeEXT = GLContext.getFunctionAddress("glGetUniformBufferSizeEXT")) != 0L ? 1 : 0) & ((this.glGetUniformOffsetEXT = GLContext.getFunctionAddress("glGetUniformOffsetEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_blend_color_initNativeFunctionAddresses()
/*      */   {
/* 3444 */     return (this.glBlendColorEXT = GLContext.getFunctionAddress("glBlendColorEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_blend_equation_separate_initNativeFunctionAddresses()
/*      */   {
/* 3449 */     return (this.glBlendEquationSeparateEXT = GLContext.getFunctionAddress("glBlendEquationSeparateEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_blend_func_separate_initNativeFunctionAddresses()
/*      */   {
/* 3454 */     return (this.glBlendFuncSeparateEXT = GLContext.getFunctionAddress("glBlendFuncSeparateEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_blend_minmax_initNativeFunctionAddresses()
/*      */   {
/* 3459 */     return (this.glBlendEquationEXT = GLContext.getFunctionAddress("glBlendEquationEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_compiled_vertex_array_initNativeFunctionAddresses()
/*      */   {
/* 3464 */     return ((this.glLockArraysEXT = GLContext.getFunctionAddress("glLockArraysEXT")) != 0L ? 1 : 0) & ((this.glUnlockArraysEXT = GLContext.getFunctionAddress("glUnlockArraysEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_depth_bounds_test_initNativeFunctionAddresses()
/*      */   {
/* 3470 */     return (this.glDepthBoundsEXT = GLContext.getFunctionAddress("glDepthBoundsEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_direct_state_access_initNativeFunctionAddresses(boolean forwardCompatible, Set<String> supported_extensions)
/*      */   {
/* 3475 */     return ((forwardCompatible) || ((this.glClientAttribDefaultEXT = GLContext.getFunctionAddress("glClientAttribDefaultEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPushClientAttribDefaultEXT = GLContext.getFunctionAddress("glPushClientAttribDefaultEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixLoadfEXT = GLContext.getFunctionAddress("glMatrixLoadfEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixLoaddEXT = GLContext.getFunctionAddress("glMatrixLoaddEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixMultfEXT = GLContext.getFunctionAddress("glMatrixMultfEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixMultdEXT = GLContext.getFunctionAddress("glMatrixMultdEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixLoadIdentityEXT = GLContext.getFunctionAddress("glMatrixLoadIdentityEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixRotatefEXT = GLContext.getFunctionAddress("glMatrixRotatefEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixRotatedEXT = GLContext.getFunctionAddress("glMatrixRotatedEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixScalefEXT = GLContext.getFunctionAddress("glMatrixScalefEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixScaledEXT = GLContext.getFunctionAddress("glMatrixScaledEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixTranslatefEXT = GLContext.getFunctionAddress("glMatrixTranslatefEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixTranslatedEXT = GLContext.getFunctionAddress("glMatrixTranslatedEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixOrthoEXT = GLContext.getFunctionAddress("glMatrixOrthoEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixFrustumEXT = GLContext.getFunctionAddress("glMatrixFrustumEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixPushEXT = GLContext.getFunctionAddress("glMatrixPushEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixPopEXT = GLContext.getFunctionAddress("glMatrixPopEXT")) != 0L) ? 1 : 0) & ((this.glTextureParameteriEXT = GLContext.getFunctionAddress("glTextureParameteriEXT")) != 0L ? 1 : 0) & ((this.glTextureParameterivEXT = GLContext.getFunctionAddress("glTextureParameterivEXT")) != 0L ? 1 : 0) & ((this.glTextureParameterfEXT = GLContext.getFunctionAddress("glTextureParameterfEXT")) != 0L ? 1 : 0) & ((this.glTextureParameterfvEXT = GLContext.getFunctionAddress("glTextureParameterfvEXT")) != 0L ? 1 : 0) & ((this.glTextureImage1DEXT = GLContext.getFunctionAddress("glTextureImage1DEXT")) != 0L ? 1 : 0) & ((this.glTextureImage2DEXT = GLContext.getFunctionAddress("glTextureImage2DEXT")) != 0L ? 1 : 0) & ((this.glTextureSubImage1DEXT = GLContext.getFunctionAddress("glTextureSubImage1DEXT")) != 0L ? 1 : 0) & ((this.glTextureSubImage2DEXT = GLContext.getFunctionAddress("glTextureSubImage2DEXT")) != 0L ? 1 : 0) & ((this.glCopyTextureImage1DEXT = GLContext.getFunctionAddress("glCopyTextureImage1DEXT")) != 0L ? 1 : 0) & ((this.glCopyTextureImage2DEXT = GLContext.getFunctionAddress("glCopyTextureImage2DEXT")) != 0L ? 1 : 0) & ((this.glCopyTextureSubImage1DEXT = GLContext.getFunctionAddress("glCopyTextureSubImage1DEXT")) != 0L ? 1 : 0) & ((this.glCopyTextureSubImage2DEXT = GLContext.getFunctionAddress("glCopyTextureSubImage2DEXT")) != 0L ? 1 : 0) & ((this.glGetTextureImageEXT = GLContext.getFunctionAddress("glGetTextureImageEXT")) != 0L ? 1 : 0) & ((this.glGetTextureParameterfvEXT = GLContext.getFunctionAddress("glGetTextureParameterfvEXT")) != 0L ? 1 : 0) & ((this.glGetTextureParameterivEXT = GLContext.getFunctionAddress("glGetTextureParameterivEXT")) != 0L ? 1 : 0) & ((this.glGetTextureLevelParameterfvEXT = GLContext.getFunctionAddress("glGetTextureLevelParameterfvEXT")) != 0L ? 1 : 0) & ((this.glGetTextureLevelParameterivEXT = GLContext.getFunctionAddress("glGetTextureLevelParameterivEXT")) != 0L ? 1 : 0) & ((!supported_extensions.contains("OpenGL12")) || ((this.glTextureImage3DEXT = GLContext.getFunctionAddress("glTextureImage3DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL12")) || ((this.glTextureSubImage3DEXT = GLContext.getFunctionAddress("glTextureSubImage3DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL12")) || ((this.glCopyTextureSubImage3DEXT = GLContext.getFunctionAddress("glCopyTextureSubImage3DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glBindMultiTextureEXT = GLContext.getFunctionAddress("glBindMultiTextureEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexCoordPointerEXT = GLContext.getFunctionAddress("glMultiTexCoordPointerEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexEnvfEXT = GLContext.getFunctionAddress("glMultiTexEnvfEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexEnvfvEXT = GLContext.getFunctionAddress("glMultiTexEnvfvEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexEnviEXT = GLContext.getFunctionAddress("glMultiTexEnviEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexEnvivEXT = GLContext.getFunctionAddress("glMultiTexEnvivEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexGendEXT = GLContext.getFunctionAddress("glMultiTexGendEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexGendvEXT = GLContext.getFunctionAddress("glMultiTexGendvEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexGenfEXT = GLContext.getFunctionAddress("glMultiTexGenfEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexGenfvEXT = GLContext.getFunctionAddress("glMultiTexGenfvEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexGeniEXT = GLContext.getFunctionAddress("glMultiTexGeniEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexGenivEXT = GLContext.getFunctionAddress("glMultiTexGenivEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexEnvfvEXT = GLContext.getFunctionAddress("glGetMultiTexEnvfvEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexEnvivEXT = GLContext.getFunctionAddress("glGetMultiTexEnvivEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexGendvEXT = GLContext.getFunctionAddress("glGetMultiTexGendvEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexGenfvEXT = GLContext.getFunctionAddress("glGetMultiTexGenfvEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexGenivEXT = GLContext.getFunctionAddress("glGetMultiTexGenivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexParameteriEXT = GLContext.getFunctionAddress("glMultiTexParameteriEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexParameterivEXT = GLContext.getFunctionAddress("glMultiTexParameterivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexParameterfEXT = GLContext.getFunctionAddress("glMultiTexParameterfEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexParameterfvEXT = GLContext.getFunctionAddress("glMultiTexParameterfvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexImage1DEXT = GLContext.getFunctionAddress("glMultiTexImage1DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexImage2DEXT = GLContext.getFunctionAddress("glMultiTexImage2DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexSubImage1DEXT = GLContext.getFunctionAddress("glMultiTexSubImage1DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexSubImage2DEXT = GLContext.getFunctionAddress("glMultiTexSubImage2DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCopyMultiTexImage1DEXT = GLContext.getFunctionAddress("glCopyMultiTexImage1DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCopyMultiTexImage2DEXT = GLContext.getFunctionAddress("glCopyMultiTexImage2DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCopyMultiTexSubImage1DEXT = GLContext.getFunctionAddress("glCopyMultiTexSubImage1DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCopyMultiTexSubImage2DEXT = GLContext.getFunctionAddress("glCopyMultiTexSubImage2DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexImageEXT = GLContext.getFunctionAddress("glGetMultiTexImageEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexParameterfvEXT = GLContext.getFunctionAddress("glGetMultiTexParameterfvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexParameterivEXT = GLContext.getFunctionAddress("glGetMultiTexParameterivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexLevelParameterfvEXT = GLContext.getFunctionAddress("glGetMultiTexLevelParameterfvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetMultiTexLevelParameterivEXT = GLContext.getFunctionAddress("glGetMultiTexLevelParameterivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexImage3DEXT = GLContext.getFunctionAddress("glMultiTexImage3DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glMultiTexSubImage3DEXT = GLContext.getFunctionAddress("glMultiTexSubImage3DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCopyMultiTexSubImage3DEXT = GLContext.getFunctionAddress("glCopyMultiTexSubImage3DEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glEnableClientStateIndexedEXT = GLContext.getFunctionAddress("glEnableClientStateIndexedEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glDisableClientStateIndexedEXT = GLContext.getFunctionAddress("glDisableClientStateIndexedEXT")) != 0L) ? 1 : 0) & 0x1 & 0x1 & (((!supported_extensions.contains("OpenGL30")) || ((this.glEnableClientStateiEXT = GLContext.getFunctionAddress("glEnableClientStateiEXT")) != 0L)) || (((!supported_extensions.contains("OpenGL30")) || ((this.glDisableClientStateiEXT = GLContext.getFunctionAddress("glDisableClientStateiEXT")) != 0L)) || ((!supported_extensions.contains("OpenGL13")) || ((this.glGetFloatIndexedvEXT = GLContext.getFunctionAddress("glGetFloatIndexedvEXT")) != 0L))) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetDoubleIndexedvEXT = GLContext.getFunctionAddress("glGetDoubleIndexedvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetPointerIndexedvEXT = GLContext.getFunctionAddress("glGetPointerIndexedvEXT")) != 0L) ? 1 : 0) & 0x1 & 0x1 & 0x1 & (((!supported_extensions.contains("OpenGL30")) || ((this.glGetFloati_vEXT = GLContext.getFunctionAddress("glGetFloati_vEXT")) != 0L)) || (((!supported_extensions.contains("OpenGL30")) || ((this.glGetDoublei_vEXT = GLContext.getFunctionAddress("glGetDoublei_vEXT")) != 0L)) || (((!supported_extensions.contains("OpenGL30")) || ((this.glGetPointeri_vEXT = GLContext.getFunctionAddress("glGetPointeri_vEXT")) != 0L)) || ((!supported_extensions.contains("OpenGL13")) || ((this.glEnableIndexedEXT = GLContext.getFunctionAddress("glEnableIndexedEXT")) != 0L)))) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glDisableIndexedEXT = GLContext.getFunctionAddress("glDisableIndexedEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glIsEnabledIndexedEXT = GLContext.getFunctionAddress("glIsEnabledIndexedEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetIntegerIndexedvEXT = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetBooleanIndexedvEXT = GLContext.getFunctionAddress("glGetBooleanIndexedvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_vertex_program")) || ((this.glNamedProgramStringEXT = GLContext.getFunctionAddress("glNamedProgramStringEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_vertex_program")) || ((this.glNamedProgramLocalParameter4dEXT = GLContext.getFunctionAddress("glNamedProgramLocalParameter4dEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_vertex_program")) || ((this.glNamedProgramLocalParameter4dvEXT = GLContext.getFunctionAddress("glNamedProgramLocalParameter4dvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_vertex_program")) || ((this.glNamedProgramLocalParameter4fEXT = GLContext.getFunctionAddress("glNamedProgramLocalParameter4fEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_vertex_program")) || ((this.glNamedProgramLocalParameter4fvEXT = GLContext.getFunctionAddress("glNamedProgramLocalParameter4fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_vertex_program")) || ((this.glGetNamedProgramLocalParameterdvEXT = GLContext.getFunctionAddress("glGetNamedProgramLocalParameterdvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_vertex_program")) || ((this.glGetNamedProgramLocalParameterfvEXT = GLContext.getFunctionAddress("glGetNamedProgramLocalParameterfvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_vertex_program")) || ((this.glGetNamedProgramivEXT = GLContext.getFunctionAddress("glGetNamedProgramivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_ARB_vertex_program")) || ((this.glGetNamedProgramStringEXT = GLContext.getFunctionAddress("glGetNamedProgramStringEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedTextureImage3DEXT = GLContext.getFunctionAddress("glCompressedTextureImage3DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedTextureImage2DEXT = GLContext.getFunctionAddress("glCompressedTextureImage2DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedTextureImage1DEXT = GLContext.getFunctionAddress("glCompressedTextureImage1DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedTextureSubImage3DEXT = GLContext.getFunctionAddress("glCompressedTextureSubImage3DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedTextureSubImage2DEXT = GLContext.getFunctionAddress("glCompressedTextureSubImage2DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedTextureSubImage1DEXT = GLContext.getFunctionAddress("glCompressedTextureSubImage1DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetCompressedTextureImageEXT = GLContext.getFunctionAddress("glGetCompressedTextureImageEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedMultiTexImage3DEXT = GLContext.getFunctionAddress("glCompressedMultiTexImage3DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedMultiTexImage2DEXT = GLContext.getFunctionAddress("glCompressedMultiTexImage2DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedMultiTexImage1DEXT = GLContext.getFunctionAddress("glCompressedMultiTexImage1DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedMultiTexSubImage3DEXT = GLContext.getFunctionAddress("glCompressedMultiTexSubImage3DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedMultiTexSubImage2DEXT = GLContext.getFunctionAddress("glCompressedMultiTexSubImage2DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glCompressedMultiTexSubImage1DEXT = GLContext.getFunctionAddress("glCompressedMultiTexSubImage1DEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL13")) || ((this.glGetCompressedMultiTexImageEXT = GLContext.getFunctionAddress("glGetCompressedMultiTexImageEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMatrixLoadTransposefEXT = GLContext.getFunctionAddress("glMatrixLoadTransposefEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMatrixLoadTransposedEXT = GLContext.getFunctionAddress("glMatrixLoadTransposedEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMatrixMultTransposefEXT = GLContext.getFunctionAddress("glMatrixMultTransposefEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL13")) || ((this.glMatrixMultTransposedEXT = GLContext.getFunctionAddress("glMatrixMultTransposedEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL15")) || ((this.glNamedBufferDataEXT = GLContext.getFunctionAddress("glNamedBufferDataEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL15")) || ((this.glNamedBufferSubDataEXT = GLContext.getFunctionAddress("glNamedBufferSubDataEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL15")) || ((this.glMapNamedBufferEXT = GLContext.getFunctionAddress("glMapNamedBufferEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL15")) || ((this.glUnmapNamedBufferEXT = GLContext.getFunctionAddress("glUnmapNamedBufferEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL15")) || ((this.glGetNamedBufferParameterivEXT = GLContext.getFunctionAddress("glGetNamedBufferParameterivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL15")) || ((this.glGetNamedBufferPointervEXT = GLContext.getFunctionAddress("glGetNamedBufferPointervEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL15")) || ((this.glGetNamedBufferSubDataEXT = GLContext.getFunctionAddress("glGetNamedBufferSubDataEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform1fEXT = GLContext.getFunctionAddress("glProgramUniform1fEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform2fEXT = GLContext.getFunctionAddress("glProgramUniform2fEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform3fEXT = GLContext.getFunctionAddress("glProgramUniform3fEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform4fEXT = GLContext.getFunctionAddress("glProgramUniform4fEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform1iEXT = GLContext.getFunctionAddress("glProgramUniform1iEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform2iEXT = GLContext.getFunctionAddress("glProgramUniform2iEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform3iEXT = GLContext.getFunctionAddress("glProgramUniform3iEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform4iEXT = GLContext.getFunctionAddress("glProgramUniform4iEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform1fvEXT = GLContext.getFunctionAddress("glProgramUniform1fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform2fvEXT = GLContext.getFunctionAddress("glProgramUniform2fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform3fvEXT = GLContext.getFunctionAddress("glProgramUniform3fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform4fvEXT = GLContext.getFunctionAddress("glProgramUniform4fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform1ivEXT = GLContext.getFunctionAddress("glProgramUniform1ivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform2ivEXT = GLContext.getFunctionAddress("glProgramUniform2ivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform3ivEXT = GLContext.getFunctionAddress("glProgramUniform3ivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniform4ivEXT = GLContext.getFunctionAddress("glProgramUniform4ivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniformMatrix2fvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix2fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniformMatrix3fvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix3fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL20")) || ((this.glProgramUniformMatrix4fvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix4fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL21")) || ((this.glProgramUniformMatrix2x3fvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix2x3fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL21")) || ((this.glProgramUniformMatrix3x2fvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix3x2fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL21")) || ((this.glProgramUniformMatrix2x4fvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix2x4fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL21")) || ((this.glProgramUniformMatrix4x2fvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix4x2fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL21")) || ((this.glProgramUniformMatrix3x4fvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix3x4fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL21")) || ((this.glProgramUniformMatrix4x3fvEXT = GLContext.getFunctionAddress("glProgramUniformMatrix4x3fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_buffer_object")) || ((this.glTextureBufferEXT = GLContext.getFunctionAddress("glTextureBufferEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_buffer_object")) || ((this.glMultiTexBufferEXT = GLContext.getFunctionAddress("glMultiTexBufferEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_integer")) || ((this.glTextureParameterIivEXT = GLContext.getFunctionAddress("glTextureParameterIivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_integer")) || ((this.glTextureParameterIuivEXT = GLContext.getFunctionAddress("glTextureParameterIuivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_integer")) || ((this.glGetTextureParameterIivEXT = GLContext.getFunctionAddress("glGetTextureParameterIivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_integer")) || ((this.glGetTextureParameterIuivEXT = GLContext.getFunctionAddress("glGetTextureParameterIuivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_integer")) || ((this.glMultiTexParameterIivEXT = GLContext.getFunctionAddress("glMultiTexParameterIivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_integer")) || ((this.glMultiTexParameterIuivEXT = GLContext.getFunctionAddress("glMultiTexParameterIuivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_integer")) || ((this.glGetMultiTexParameterIivEXT = GLContext.getFunctionAddress("glGetMultiTexParameterIivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_texture_integer")) || ((this.glGetMultiTexParameterIuivEXT = GLContext.getFunctionAddress("glGetMultiTexParameterIuivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_gpu_shader4")) || ((this.glProgramUniform1uiEXT = GLContext.getFunctionAddress("glProgramUniform1uiEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_gpu_shader4")) || ((this.glProgramUniform2uiEXT = GLContext.getFunctionAddress("glProgramUniform2uiEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_gpu_shader4")) || ((this.glProgramUniform3uiEXT = GLContext.getFunctionAddress("glProgramUniform3uiEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_gpu_shader4")) || ((this.glProgramUniform4uiEXT = GLContext.getFunctionAddress("glProgramUniform4uiEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_gpu_shader4")) || ((this.glProgramUniform1uivEXT = GLContext.getFunctionAddress("glProgramUniform1uivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_gpu_shader4")) || ((this.glProgramUniform2uivEXT = GLContext.getFunctionAddress("glProgramUniform2uivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_gpu_shader4")) || ((this.glProgramUniform3uivEXT = GLContext.getFunctionAddress("glProgramUniform3uivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_gpu_shader4")) || ((this.glProgramUniform4uivEXT = GLContext.getFunctionAddress("glProgramUniform4uivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_gpu_program_parameters")) || ((this.glNamedProgramLocalParameters4fvEXT = GLContext.getFunctionAddress("glNamedProgramLocalParameters4fvEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_gpu_program4")) || ((this.glNamedProgramLocalParameterI4iEXT = GLContext.getFunctionAddress("glNamedProgramLocalParameterI4iEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_gpu_program4")) || ((this.glNamedProgramLocalParameterI4ivEXT = GLContext.getFunctionAddress("glNamedProgramLocalParameterI4ivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_gpu_program4")) || ((this.glNamedProgramLocalParametersI4ivEXT = GLContext.getFunctionAddress("glNamedProgramLocalParametersI4ivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_gpu_program4")) || ((this.glNamedProgramLocalParameterI4uiEXT = GLContext.getFunctionAddress("glNamedProgramLocalParameterI4uiEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_gpu_program4")) || ((this.glNamedProgramLocalParameterI4uivEXT = GLContext.getFunctionAddress("glNamedProgramLocalParameterI4uivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_gpu_program4")) || ((this.glNamedProgramLocalParametersI4uivEXT = GLContext.getFunctionAddress("glNamedProgramLocalParametersI4uivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_gpu_program4")) || ((this.glGetNamedProgramLocalParameterIivEXT = GLContext.getFunctionAddress("glGetNamedProgramLocalParameterIivEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_gpu_program4")) || ((this.glGetNamedProgramLocalParameterIuivEXT = GLContext.getFunctionAddress("glGetNamedProgramLocalParameterIuivEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glNamedRenderbufferStorageEXT = GLContext.getFunctionAddress("glNamedRenderbufferStorageEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glGetNamedRenderbufferParameterivEXT = GLContext.getFunctionAddress("glGetNamedRenderbufferParameterivEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_multisample"))) || ((this.glNamedRenderbufferStorageMultisampleEXT = GLContext.getFunctionAddress("glNamedRenderbufferStorageMultisampleEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_framebuffer_multisample_coverage")) || ((this.glNamedRenderbufferStorageMultisampleCoverageEXT = GLContext.getFunctionAddress("glNamedRenderbufferStorageMultisampleCoverageEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glCheckNamedFramebufferStatusEXT = GLContext.getFunctionAddress("glCheckNamedFramebufferStatusEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glNamedFramebufferTexture1DEXT = GLContext.getFunctionAddress("glNamedFramebufferTexture1DEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glNamedFramebufferTexture2DEXT = GLContext.getFunctionAddress("glNamedFramebufferTexture2DEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glNamedFramebufferTexture3DEXT = GLContext.getFunctionAddress("glNamedFramebufferTexture3DEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glNamedFramebufferRenderbufferEXT = GLContext.getFunctionAddress("glNamedFramebufferRenderbufferEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glGetNamedFramebufferAttachmentParameterivEXT = GLContext.getFunctionAddress("glGetNamedFramebufferAttachmentParameterivEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glGenerateTextureMipmapEXT = GLContext.getFunctionAddress("glGenerateTextureMipmapEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glGenerateMultiTexMipmapEXT = GLContext.getFunctionAddress("glGenerateMultiTexMipmapEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glFramebufferDrawBufferEXT = GLContext.getFunctionAddress("glFramebufferDrawBufferEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glFramebufferDrawBuffersEXT = GLContext.getFunctionAddress("glFramebufferDrawBuffersEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glFramebufferReadBufferEXT = GLContext.getFunctionAddress("glFramebufferReadBufferEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL30")) && (!supported_extensions.contains("GL_EXT_framebuffer_object"))) || ((this.glGetFramebufferParameterivEXT = GLContext.getFunctionAddress("glGetFramebufferParameterivEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("OpenGL31")) && (!supported_extensions.contains("GL_ARB_copy_buffer"))) || ((this.glNamedCopyBufferSubDataEXT = GLContext.getFunctionAddress("glNamedCopyBufferSubDataEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("GL_EXT_geometry_shader4")) && (!supported_extensions.contains("GL_NV_geometry_program4"))) || ((this.glNamedFramebufferTextureEXT = GLContext.getFunctionAddress("glNamedFramebufferTextureEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("GL_EXT_geometry_shader4")) && (!supported_extensions.contains("GL_NV_geometry_program4"))) || ((this.glNamedFramebufferTextureLayerEXT = GLContext.getFunctionAddress("glNamedFramebufferTextureLayerEXT")) != 0L) ? 1 : 0) & (((!supported_extensions.contains("GL_EXT_geometry_shader4")) && (!supported_extensions.contains("GL_NV_geometry_program4"))) || ((this.glNamedFramebufferTextureFaceEXT = GLContext.getFunctionAddress("glNamedFramebufferTextureFaceEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_explicit_multisample")) || ((this.glTextureRenderbufferEXT = GLContext.getFunctionAddress("glTextureRenderbufferEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_NV_explicit_multisample")) || ((this.glMultiTexRenderbufferEXT = GLContext.getFunctionAddress("glMultiTexRenderbufferEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayVertexOffsetEXT = GLContext.getFunctionAddress("glVertexArrayVertexOffsetEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayColorOffsetEXT = GLContext.getFunctionAddress("glVertexArrayColorOffsetEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayEdgeFlagOffsetEXT = GLContext.getFunctionAddress("glVertexArrayEdgeFlagOffsetEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayIndexOffsetEXT = GLContext.getFunctionAddress("glVertexArrayIndexOffsetEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayNormalOffsetEXT = GLContext.getFunctionAddress("glVertexArrayNormalOffsetEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayTexCoordOffsetEXT = GLContext.getFunctionAddress("glVertexArrayTexCoordOffsetEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayMultiTexCoordOffsetEXT = GLContext.getFunctionAddress("glVertexArrayMultiTexCoordOffsetEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayFogCoordOffsetEXT = GLContext.getFunctionAddress("glVertexArrayFogCoordOffsetEXT")) != 0L) ? 1 : 0) & ((forwardCompatible) || (!supported_extensions.contains("OpenGL30")) || ((this.glVertexArraySecondaryColorOffsetEXT = GLContext.getFunctionAddress("glVertexArraySecondaryColorOffsetEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayVertexAttribOffsetEXT = GLContext.getFunctionAddress("glVertexArrayVertexAttribOffsetEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glVertexArrayVertexAttribIOffsetEXT = GLContext.getFunctionAddress("glVertexArrayVertexAttribIOffsetEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glEnableVertexArrayEXT = GLContext.getFunctionAddress("glEnableVertexArrayEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glDisableVertexArrayEXT = GLContext.getFunctionAddress("glDisableVertexArrayEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glEnableVertexArrayAttribEXT = GLContext.getFunctionAddress("glEnableVertexArrayAttribEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glDisableVertexArrayAttribEXT = GLContext.getFunctionAddress("glDisableVertexArrayAttribEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glGetVertexArrayIntegervEXT = GLContext.getFunctionAddress("glGetVertexArrayIntegervEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glGetVertexArrayPointervEXT = GLContext.getFunctionAddress("glGetVertexArrayPointervEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glGetVertexArrayIntegeri_vEXT = GLContext.getFunctionAddress("glGetVertexArrayIntegeri_vEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glGetVertexArrayPointeri_vEXT = GLContext.getFunctionAddress("glGetVertexArrayPointeri_vEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glMapNamedBufferRangeEXT = GLContext.getFunctionAddress("glMapNamedBufferRangeEXT")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("OpenGL30")) || ((this.glFlushMappedNamedBufferRangeEXT = GLContext.getFunctionAddress("glFlushMappedNamedBufferRangeEXT")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_draw_buffers2_initNativeFunctionAddresses()
/*      */   {
/* 3697 */     return ((this.glColorMaskIndexedEXT = GLContext.getFunctionAddress("glColorMaskIndexedEXT")) != 0L ? 1 : 0) & ((this.glGetBooleanIndexedvEXT = GLContext.getFunctionAddress("glGetBooleanIndexedvEXT")) != 0L ? 1 : 0) & ((this.glGetIntegerIndexedvEXT = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT")) != 0L ? 1 : 0) & ((this.glEnableIndexedEXT = GLContext.getFunctionAddress("glEnableIndexedEXT")) != 0L ? 1 : 0) & ((this.glDisableIndexedEXT = GLContext.getFunctionAddress("glDisableIndexedEXT")) != 0L ? 1 : 0) & ((this.glIsEnabledIndexedEXT = GLContext.getFunctionAddress("glIsEnabledIndexedEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_draw_instanced_initNativeFunctionAddresses()
/*      */   {
/* 3707 */     return ((this.glDrawArraysInstancedEXT = GLContext.getFunctionAddress("glDrawArraysInstancedEXT")) != 0L ? 1 : 0) & ((this.glDrawElementsInstancedEXT = GLContext.getFunctionAddress("glDrawElementsInstancedEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_draw_range_elements_initNativeFunctionAddresses()
/*      */   {
/* 3713 */     return (this.glDrawRangeElementsEXT = GLContext.getFunctionAddress("glDrawRangeElementsEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_fog_coord_initNativeFunctionAddresses()
/*      */   {
/* 3718 */     return ((this.glFogCoordfEXT = GLContext.getFunctionAddress("glFogCoordfEXT")) != 0L ? 1 : 0) & ((this.glFogCoorddEXT = GLContext.getFunctionAddress("glFogCoorddEXT")) != 0L ? 1 : 0) & ((this.glFogCoordPointerEXT = GLContext.getFunctionAddress("glFogCoordPointerEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_framebuffer_blit_initNativeFunctionAddresses()
/*      */   {
/* 3725 */     return (this.glBlitFramebufferEXT = GLContext.getFunctionAddress("glBlitFramebufferEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_framebuffer_multisample_initNativeFunctionAddresses()
/*      */   {
/* 3730 */     return (this.glRenderbufferStorageMultisampleEXT = GLContext.getFunctionAddress("glRenderbufferStorageMultisampleEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_framebuffer_object_initNativeFunctionAddresses()
/*      */   {
/* 3735 */     return ((this.glIsRenderbufferEXT = GLContext.getFunctionAddress("glIsRenderbufferEXT")) != 0L ? 1 : 0) & ((this.glBindRenderbufferEXT = GLContext.getFunctionAddress("glBindRenderbufferEXT")) != 0L ? 1 : 0) & ((this.glDeleteRenderbuffersEXT = GLContext.getFunctionAddress("glDeleteRenderbuffersEXT")) != 0L ? 1 : 0) & ((this.glGenRenderbuffersEXT = GLContext.getFunctionAddress("glGenRenderbuffersEXT")) != 0L ? 1 : 0) & ((this.glRenderbufferStorageEXT = GLContext.getFunctionAddress("glRenderbufferStorageEXT")) != 0L ? 1 : 0) & ((this.glGetRenderbufferParameterivEXT = GLContext.getFunctionAddress("glGetRenderbufferParameterivEXT")) != 0L ? 1 : 0) & ((this.glIsFramebufferEXT = GLContext.getFunctionAddress("glIsFramebufferEXT")) != 0L ? 1 : 0) & ((this.glBindFramebufferEXT = GLContext.getFunctionAddress("glBindFramebufferEXT")) != 0L ? 1 : 0) & ((this.glDeleteFramebuffersEXT = GLContext.getFunctionAddress("glDeleteFramebuffersEXT")) != 0L ? 1 : 0) & ((this.glGenFramebuffersEXT = GLContext.getFunctionAddress("glGenFramebuffersEXT")) != 0L ? 1 : 0) & ((this.glCheckFramebufferStatusEXT = GLContext.getFunctionAddress("glCheckFramebufferStatusEXT")) != 0L ? 1 : 0) & ((this.glFramebufferTexture1DEXT = GLContext.getFunctionAddress("glFramebufferTexture1DEXT")) != 0L ? 1 : 0) & ((this.glFramebufferTexture2DEXT = GLContext.getFunctionAddress("glFramebufferTexture2DEXT")) != 0L ? 1 : 0) & ((this.glFramebufferTexture3DEXT = GLContext.getFunctionAddress("glFramebufferTexture3DEXT")) != 0L ? 1 : 0) & ((this.glFramebufferRenderbufferEXT = GLContext.getFunctionAddress("glFramebufferRenderbufferEXT")) != 0L ? 1 : 0) & ((this.glGetFramebufferAttachmentParameterivEXT = GLContext.getFunctionAddress("glGetFramebufferAttachmentParameterivEXT")) != 0L ? 1 : 0) & ((this.glGenerateMipmapEXT = GLContext.getFunctionAddress("glGenerateMipmapEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_geometry_shader4_initNativeFunctionAddresses()
/*      */   {
/* 3756 */     return ((this.glProgramParameteriEXT = GLContext.getFunctionAddress("glProgramParameteriEXT")) != 0L ? 1 : 0) & ((this.glFramebufferTextureEXT = GLContext.getFunctionAddress("glFramebufferTextureEXT")) != 0L ? 1 : 0) & ((this.glFramebufferTextureLayerEXT = GLContext.getFunctionAddress("glFramebufferTextureLayerEXT")) != 0L ? 1 : 0) & ((this.glFramebufferTextureFaceEXT = GLContext.getFunctionAddress("glFramebufferTextureFaceEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_gpu_program_parameters_initNativeFunctionAddresses()
/*      */   {
/* 3764 */     return ((this.glProgramEnvParameters4fvEXT = GLContext.getFunctionAddress("glProgramEnvParameters4fvEXT")) != 0L ? 1 : 0) & ((this.glProgramLocalParameters4fvEXT = GLContext.getFunctionAddress("glProgramLocalParameters4fvEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_gpu_shader4_initNativeFunctionAddresses()
/*      */   {
/* 3770 */     return ((this.glVertexAttribI1iEXT = GLContext.getFunctionAddress("glVertexAttribI1iEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI2iEXT = GLContext.getFunctionAddress("glVertexAttribI2iEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI3iEXT = GLContext.getFunctionAddress("glVertexAttribI3iEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI4iEXT = GLContext.getFunctionAddress("glVertexAttribI4iEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI1uiEXT = GLContext.getFunctionAddress("glVertexAttribI1uiEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI2uiEXT = GLContext.getFunctionAddress("glVertexAttribI2uiEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI3uiEXT = GLContext.getFunctionAddress("glVertexAttribI3uiEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI4uiEXT = GLContext.getFunctionAddress("glVertexAttribI4uiEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI1ivEXT = GLContext.getFunctionAddress("glVertexAttribI1ivEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI2ivEXT = GLContext.getFunctionAddress("glVertexAttribI2ivEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI3ivEXT = GLContext.getFunctionAddress("glVertexAttribI3ivEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI4ivEXT = GLContext.getFunctionAddress("glVertexAttribI4ivEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI1uivEXT = GLContext.getFunctionAddress("glVertexAttribI1uivEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI2uivEXT = GLContext.getFunctionAddress("glVertexAttribI2uivEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI3uivEXT = GLContext.getFunctionAddress("glVertexAttribI3uivEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI4uivEXT = GLContext.getFunctionAddress("glVertexAttribI4uivEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI4bvEXT = GLContext.getFunctionAddress("glVertexAttribI4bvEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI4svEXT = GLContext.getFunctionAddress("glVertexAttribI4svEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI4ubvEXT = GLContext.getFunctionAddress("glVertexAttribI4ubvEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribI4usvEXT = GLContext.getFunctionAddress("glVertexAttribI4usvEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribIPointerEXT = GLContext.getFunctionAddress("glVertexAttribIPointerEXT")) != 0L ? 1 : 0) & ((this.glGetVertexAttribIivEXT = GLContext.getFunctionAddress("glGetVertexAttribIivEXT")) != 0L ? 1 : 0) & ((this.glGetVertexAttribIuivEXT = GLContext.getFunctionAddress("glGetVertexAttribIuivEXT")) != 0L ? 1 : 0) & ((this.glUniform1uiEXT = GLContext.getFunctionAddress("glUniform1uiEXT")) != 0L ? 1 : 0) & ((this.glUniform2uiEXT = GLContext.getFunctionAddress("glUniform2uiEXT")) != 0L ? 1 : 0) & ((this.glUniform3uiEXT = GLContext.getFunctionAddress("glUniform3uiEXT")) != 0L ? 1 : 0) & ((this.glUniform4uiEXT = GLContext.getFunctionAddress("glUniform4uiEXT")) != 0L ? 1 : 0) & ((this.glUniform1uivEXT = GLContext.getFunctionAddress("glUniform1uivEXT")) != 0L ? 1 : 0) & ((this.glUniform2uivEXT = GLContext.getFunctionAddress("glUniform2uivEXT")) != 0L ? 1 : 0) & ((this.glUniform3uivEXT = GLContext.getFunctionAddress("glUniform3uivEXT")) != 0L ? 1 : 0) & ((this.glUniform4uivEXT = GLContext.getFunctionAddress("glUniform4uivEXT")) != 0L ? 1 : 0) & ((this.glGetUniformuivEXT = GLContext.getFunctionAddress("glGetUniformuivEXT")) != 0L ? 1 : 0) & ((this.glBindFragDataLocationEXT = GLContext.getFunctionAddress("glBindFragDataLocationEXT")) != 0L ? 1 : 0) & ((this.glGetFragDataLocationEXT = GLContext.getFunctionAddress("glGetFragDataLocationEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_multi_draw_arrays_initNativeFunctionAddresses()
/*      */   {
/* 3808 */     return (this.glMultiDrawArraysEXT = GLContext.getFunctionAddress("glMultiDrawArraysEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_paletted_texture_initNativeFunctionAddresses()
/*      */   {
/* 3813 */     return ((this.glColorTableEXT = GLContext.getFunctionAddress("glColorTableEXT")) != 0L ? 1 : 0) & ((this.glColorSubTableEXT = GLContext.getFunctionAddress("glColorSubTableEXT")) != 0L ? 1 : 0) & ((this.glGetColorTableEXT = GLContext.getFunctionAddress("glGetColorTableEXT")) != 0L ? 1 : 0) & ((this.glGetColorTableParameterivEXT = GLContext.getFunctionAddress("glGetColorTableParameterivEXT")) != 0L ? 1 : 0) & ((this.glGetColorTableParameterfvEXT = GLContext.getFunctionAddress("glGetColorTableParameterfvEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_point_parameters_initNativeFunctionAddresses()
/*      */   {
/* 3822 */     return ((this.glPointParameterfEXT = GLContext.getFunctionAddress("glPointParameterfEXT")) != 0L ? 1 : 0) & ((this.glPointParameterfvEXT = GLContext.getFunctionAddress("glPointParameterfvEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_provoking_vertex_initNativeFunctionAddresses()
/*      */   {
/* 3828 */     return (this.glProvokingVertexEXT = GLContext.getFunctionAddress("glProvokingVertexEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_secondary_color_initNativeFunctionAddresses()
/*      */   {
/* 3833 */     return ((this.glSecondaryColor3bEXT = GLContext.getFunctionAddress("glSecondaryColor3bEXT")) != 0L ? 1 : 0) & ((this.glSecondaryColor3fEXT = GLContext.getFunctionAddress("glSecondaryColor3fEXT")) != 0L ? 1 : 0) & ((this.glSecondaryColor3dEXT = GLContext.getFunctionAddress("glSecondaryColor3dEXT")) != 0L ? 1 : 0) & ((this.glSecondaryColor3ubEXT = GLContext.getFunctionAddress("glSecondaryColor3ubEXT")) != 0L ? 1 : 0) & ((this.glSecondaryColorPointerEXT = GLContext.getFunctionAddress("glSecondaryColorPointerEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_separate_shader_objects_initNativeFunctionAddresses()
/*      */   {
/* 3842 */     return ((this.glUseShaderProgramEXT = GLContext.getFunctionAddress("glUseShaderProgramEXT")) != 0L ? 1 : 0) & ((this.glActiveProgramEXT = GLContext.getFunctionAddress("glActiveProgramEXT")) != 0L ? 1 : 0) & ((this.glCreateShaderProgramEXT = GLContext.getFunctionAddress("glCreateShaderProgramEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_shader_image_load_store_initNativeFunctionAddresses()
/*      */   {
/* 3849 */     return ((this.glBindImageTextureEXT = GLContext.getFunctionAddress("glBindImageTextureEXT")) != 0L ? 1 : 0) & ((this.glMemoryBarrierEXT = GLContext.getFunctionAddress("glMemoryBarrierEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_stencil_clear_tag_initNativeFunctionAddresses()
/*      */   {
/* 3855 */     return (this.glStencilClearTagEXT = GLContext.getFunctionAddress("glStencilClearTagEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_stencil_two_side_initNativeFunctionAddresses()
/*      */   {
/* 3860 */     return (this.glActiveStencilFaceEXT = GLContext.getFunctionAddress("glActiveStencilFaceEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_texture_array_initNativeFunctionAddresses()
/*      */   {
/* 3865 */     return (this.glFramebufferTextureLayerEXT = GLContext.getFunctionAddress("glFramebufferTextureLayerEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_texture_buffer_object_initNativeFunctionAddresses()
/*      */   {
/* 3870 */     return (this.glTexBufferEXT = GLContext.getFunctionAddress("glTexBufferEXT")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean EXT_texture_integer_initNativeFunctionAddresses()
/*      */   {
/* 3875 */     return ((this.glClearColorIiEXT = GLContext.getFunctionAddress("glClearColorIiEXT")) != 0L ? 1 : 0) & ((this.glClearColorIuiEXT = GLContext.getFunctionAddress("glClearColorIuiEXT")) != 0L ? 1 : 0) & ((this.glTexParameterIivEXT = GLContext.getFunctionAddress("glTexParameterIivEXT")) != 0L ? 1 : 0) & ((this.glTexParameterIuivEXT = GLContext.getFunctionAddress("glTexParameterIuivEXT")) != 0L ? 1 : 0) & ((this.glGetTexParameterIivEXT = GLContext.getFunctionAddress("glGetTexParameterIivEXT")) != 0L ? 1 : 0) & ((this.glGetTexParameterIuivEXT = GLContext.getFunctionAddress("glGetTexParameterIuivEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_timer_query_initNativeFunctionAddresses()
/*      */   {
/* 3885 */     return ((this.glGetQueryObjecti64vEXT = GLContext.getFunctionAddress("glGetQueryObjecti64vEXT")) != 0L ? 1 : 0) & ((this.glGetQueryObjectui64vEXT = GLContext.getFunctionAddress("glGetQueryObjectui64vEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_transform_feedback_initNativeFunctionAddresses()
/*      */   {
/* 3891 */     return ((this.glBindBufferRangeEXT = GLContext.getFunctionAddress("glBindBufferRangeEXT")) != 0L ? 1 : 0) & ((this.glBindBufferOffsetEXT = GLContext.getFunctionAddress("glBindBufferOffsetEXT")) != 0L ? 1 : 0) & ((this.glBindBufferBaseEXT = GLContext.getFunctionAddress("glBindBufferBaseEXT")) != 0L ? 1 : 0) & ((this.glBeginTransformFeedbackEXT = GLContext.getFunctionAddress("glBeginTransformFeedbackEXT")) != 0L ? 1 : 0) & ((this.glEndTransformFeedbackEXT = GLContext.getFunctionAddress("glEndTransformFeedbackEXT")) != 0L ? 1 : 0) & ((this.glTransformFeedbackVaryingsEXT = GLContext.getFunctionAddress("glTransformFeedbackVaryingsEXT")) != 0L ? 1 : 0) & ((this.glGetTransformFeedbackVaryingEXT = GLContext.getFunctionAddress("glGetTransformFeedbackVaryingEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_vertex_attrib_64bit_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 3902 */     return ((this.glVertexAttribL1dEXT = GLContext.getFunctionAddress("glVertexAttribL1dEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribL2dEXT = GLContext.getFunctionAddress("glVertexAttribL2dEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribL3dEXT = GLContext.getFunctionAddress("glVertexAttribL3dEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribL4dEXT = GLContext.getFunctionAddress("glVertexAttribL4dEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribL1dvEXT = GLContext.getFunctionAddress("glVertexAttribL1dvEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribL2dvEXT = GLContext.getFunctionAddress("glVertexAttribL2dvEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribL3dvEXT = GLContext.getFunctionAddress("glVertexAttribL3dvEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribL4dvEXT = GLContext.getFunctionAddress("glVertexAttribL4dvEXT")) != 0L ? 1 : 0) & ((this.glVertexAttribLPointerEXT = GLContext.getFunctionAddress("glVertexAttribLPointerEXT")) != 0L ? 1 : 0) & ((this.glGetVertexAttribLdvEXT = GLContext.getFunctionAddress("glGetVertexAttribLdvEXT")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glVertexArrayVertexAttribLOffsetEXT = GLContext.getFunctionAddress("glVertexArrayVertexAttribLOffsetEXT")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_vertex_shader_initNativeFunctionAddresses()
/*      */   {
/* 3917 */     return ((this.glBeginVertexShaderEXT = GLContext.getFunctionAddress("glBeginVertexShaderEXT")) != 0L ? 1 : 0) & ((this.glEndVertexShaderEXT = GLContext.getFunctionAddress("glEndVertexShaderEXT")) != 0L ? 1 : 0) & ((this.glBindVertexShaderEXT = GLContext.getFunctionAddress("glBindVertexShaderEXT")) != 0L ? 1 : 0) & ((this.glGenVertexShadersEXT = GLContext.getFunctionAddress("glGenVertexShadersEXT")) != 0L ? 1 : 0) & ((this.glDeleteVertexShaderEXT = GLContext.getFunctionAddress("glDeleteVertexShaderEXT")) != 0L ? 1 : 0) & ((this.glShaderOp1EXT = GLContext.getFunctionAddress("glShaderOp1EXT")) != 0L ? 1 : 0) & ((this.glShaderOp2EXT = GLContext.getFunctionAddress("glShaderOp2EXT")) != 0L ? 1 : 0) & ((this.glShaderOp3EXT = GLContext.getFunctionAddress("glShaderOp3EXT")) != 0L ? 1 : 0) & ((this.glSwizzleEXT = GLContext.getFunctionAddress("glSwizzleEXT")) != 0L ? 1 : 0) & ((this.glWriteMaskEXT = GLContext.getFunctionAddress("glWriteMaskEXT")) != 0L ? 1 : 0) & ((this.glInsertComponentEXT = GLContext.getFunctionAddress("glInsertComponentEXT")) != 0L ? 1 : 0) & ((this.glExtractComponentEXT = GLContext.getFunctionAddress("glExtractComponentEXT")) != 0L ? 1 : 0) & ((this.glGenSymbolsEXT = GLContext.getFunctionAddress("glGenSymbolsEXT")) != 0L ? 1 : 0) & ((this.glSetInvariantEXT = GLContext.getFunctionAddress("glSetInvariantEXT")) != 0L ? 1 : 0) & ((this.glSetLocalConstantEXT = GLContext.getFunctionAddress("glSetLocalConstantEXT")) != 0L ? 1 : 0) & ((this.glVariantbvEXT = GLContext.getFunctionAddress("glVariantbvEXT")) != 0L ? 1 : 0) & ((this.glVariantsvEXT = GLContext.getFunctionAddress("glVariantsvEXT")) != 0L ? 1 : 0) & ((this.glVariantivEXT = GLContext.getFunctionAddress("glVariantivEXT")) != 0L ? 1 : 0) & ((this.glVariantfvEXT = GLContext.getFunctionAddress("glVariantfvEXT")) != 0L ? 1 : 0) & ((this.glVariantdvEXT = GLContext.getFunctionAddress("glVariantdvEXT")) != 0L ? 1 : 0) & ((this.glVariantubvEXT = GLContext.getFunctionAddress("glVariantubvEXT")) != 0L ? 1 : 0) & ((this.glVariantusvEXT = GLContext.getFunctionAddress("glVariantusvEXT")) != 0L ? 1 : 0) & ((this.glVariantuivEXT = GLContext.getFunctionAddress("glVariantuivEXT")) != 0L ? 1 : 0) & ((this.glVariantPointerEXT = GLContext.getFunctionAddress("glVariantPointerEXT")) != 0L ? 1 : 0) & ((this.glEnableVariantClientStateEXT = GLContext.getFunctionAddress("glEnableVariantClientStateEXT")) != 0L ? 1 : 0) & ((this.glDisableVariantClientStateEXT = GLContext.getFunctionAddress("glDisableVariantClientStateEXT")) != 0L ? 1 : 0) & ((this.glBindLightParameterEXT = GLContext.getFunctionAddress("glBindLightParameterEXT")) != 0L ? 1 : 0) & ((this.glBindMaterialParameterEXT = GLContext.getFunctionAddress("glBindMaterialParameterEXT")) != 0L ? 1 : 0) & ((this.glBindTexGenParameterEXT = GLContext.getFunctionAddress("glBindTexGenParameterEXT")) != 0L ? 1 : 0) & ((this.glBindTextureUnitParameterEXT = GLContext.getFunctionAddress("glBindTextureUnitParameterEXT")) != 0L ? 1 : 0) & ((this.glBindParameterEXT = GLContext.getFunctionAddress("glBindParameterEXT")) != 0L ? 1 : 0) & ((this.glIsVariantEnabledEXT = GLContext.getFunctionAddress("glIsVariantEnabledEXT")) != 0L ? 1 : 0) & ((this.glGetVariantBooleanvEXT = GLContext.getFunctionAddress("glGetVariantBooleanvEXT")) != 0L ? 1 : 0) & ((this.glGetVariantIntegervEXT = GLContext.getFunctionAddress("glGetVariantIntegervEXT")) != 0L ? 1 : 0) & ((this.glGetVariantFloatvEXT = GLContext.getFunctionAddress("glGetVariantFloatvEXT")) != 0L ? 1 : 0) & ((this.glGetVariantPointervEXT = GLContext.getFunctionAddress("glGetVariantPointervEXT")) != 0L ? 1 : 0) & ((this.glGetInvariantBooleanvEXT = GLContext.getFunctionAddress("glGetInvariantBooleanvEXT")) != 0L ? 1 : 0) & ((this.glGetInvariantIntegervEXT = GLContext.getFunctionAddress("glGetInvariantIntegervEXT")) != 0L ? 1 : 0) & ((this.glGetInvariantFloatvEXT = GLContext.getFunctionAddress("glGetInvariantFloatvEXT")) != 0L ? 1 : 0) & ((this.glGetLocalConstantBooleanvEXT = GLContext.getFunctionAddress("glGetLocalConstantBooleanvEXT")) != 0L ? 1 : 0) & ((this.glGetLocalConstantIntegervEXT = GLContext.getFunctionAddress("glGetLocalConstantIntegervEXT")) != 0L ? 1 : 0) & ((this.glGetLocalConstantFloatvEXT = GLContext.getFunctionAddress("glGetLocalConstantFloatvEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean EXT_vertex_weighting_initNativeFunctionAddresses()
/*      */   {
/* 3963 */     return ((this.glVertexWeightfEXT = GLContext.getFunctionAddress("glVertexWeightfEXT")) != 0L ? 1 : 0) & ((this.glVertexWeightPointerEXT = GLContext.getFunctionAddress("glVertexWeightPointerEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL11_initNativeFunctionAddresses(boolean forwardCompatible)
/*      */   {
/* 3969 */     return ((forwardCompatible) || ((this.glAccum = GLContext.getFunctionAddress("glAccum")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glAlphaFunc = GLContext.getFunctionAddress("glAlphaFunc")) != 0L) ? 1 : 0) & ((this.glClearColor = GLContext.getFunctionAddress("glClearColor")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glClearAccum = GLContext.getFunctionAddress("glClearAccum")) != 0L) ? 1 : 0) & ((this.glClear = GLContext.getFunctionAddress("glClear")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glCallLists = GLContext.getFunctionAddress("glCallLists")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glCallList = GLContext.getFunctionAddress("glCallList")) != 0L) ? 1 : 0) & ((this.glBlendFunc = GLContext.getFunctionAddress("glBlendFunc")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glBitmap = GLContext.getFunctionAddress("glBitmap")) != 0L) ? 1 : 0) & ((this.glBindTexture = GLContext.getFunctionAddress("glBindTexture")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glPrioritizeTextures = GLContext.getFunctionAddress("glPrioritizeTextures")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glAreTexturesResident = GLContext.getFunctionAddress("glAreTexturesResident")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glBegin = GLContext.getFunctionAddress("glBegin")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEnd = GLContext.getFunctionAddress("glEnd")) != 0L) ? 1 : 0) & ((this.glArrayElement = GLContext.getFunctionAddress("glArrayElement")) != 0L ? 1 : 0) & ((this.glClearDepth = GLContext.getFunctionAddress("glClearDepth")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glDeleteLists = GLContext.getFunctionAddress("glDeleteLists")) != 0L) ? 1 : 0) & ((this.glDeleteTextures = GLContext.getFunctionAddress("glDeleteTextures")) != 0L ? 1 : 0) & ((this.glCullFace = GLContext.getFunctionAddress("glCullFace")) != 0L ? 1 : 0) & ((this.glCopyTexSubImage2D = GLContext.getFunctionAddress("glCopyTexSubImage2D")) != 0L ? 1 : 0) & ((this.glCopyTexSubImage1D = GLContext.getFunctionAddress("glCopyTexSubImage1D")) != 0L ? 1 : 0) & ((this.glCopyTexImage2D = GLContext.getFunctionAddress("glCopyTexImage2D")) != 0L ? 1 : 0) & ((this.glCopyTexImage1D = GLContext.getFunctionAddress("glCopyTexImage1D")) != 0L ? 1 : 0) & ((this.glCopyPixels = GLContext.getFunctionAddress("glCopyPixels")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glColorPointer = GLContext.getFunctionAddress("glColorPointer")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColorMaterial = GLContext.getFunctionAddress("glColorMaterial")) != 0L) ? 1 : 0) & ((this.glColorMask = GLContext.getFunctionAddress("glColorMask")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glColor3b = GLContext.getFunctionAddress("glColor3b")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColor3f = GLContext.getFunctionAddress("glColor3f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColor3d = GLContext.getFunctionAddress("glColor3d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColor3ub = GLContext.getFunctionAddress("glColor3ub")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColor4b = GLContext.getFunctionAddress("glColor4b")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColor4f = GLContext.getFunctionAddress("glColor4f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColor4d = GLContext.getFunctionAddress("glColor4d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColor4ub = GLContext.getFunctionAddress("glColor4ub")) != 0L) ? 1 : 0) & ((this.glClipPlane = GLContext.getFunctionAddress("glClipPlane")) != 0L ? 1 : 0) & ((this.glClearStencil = GLContext.getFunctionAddress("glClearStencil")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glEvalPoint1 = GLContext.getFunctionAddress("glEvalPoint1")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEvalPoint2 = GLContext.getFunctionAddress("glEvalPoint2")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEvalMesh1 = GLContext.getFunctionAddress("glEvalMesh1")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEvalMesh2 = GLContext.getFunctionAddress("glEvalMesh2")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEvalCoord1f = GLContext.getFunctionAddress("glEvalCoord1f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEvalCoord1d = GLContext.getFunctionAddress("glEvalCoord1d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEvalCoord2f = GLContext.getFunctionAddress("glEvalCoord2f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEvalCoord2d = GLContext.getFunctionAddress("glEvalCoord2d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEnableClientState = GLContext.getFunctionAddress("glEnableClientState")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glDisableClientState = GLContext.getFunctionAddress("glDisableClientState")) != 0L) ? 1 : 0) & ((this.glEnable = GLContext.getFunctionAddress("glEnable")) != 0L ? 1 : 0) & ((this.glDisable = GLContext.getFunctionAddress("glDisable")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glEdgeFlagPointer = GLContext.getFunctionAddress("glEdgeFlagPointer")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEdgeFlag = GLContext.getFunctionAddress("glEdgeFlag")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glDrawPixels = GLContext.getFunctionAddress("glDrawPixels")) != 0L) ? 1 : 0) & ((this.glDrawElements = GLContext.getFunctionAddress("glDrawElements")) != 0L ? 1 : 0) & ((this.glDrawBuffer = GLContext.getFunctionAddress("glDrawBuffer")) != 0L ? 1 : 0) & ((this.glDrawArrays = GLContext.getFunctionAddress("glDrawArrays")) != 0L ? 1 : 0) & ((this.glDepthRange = GLContext.getFunctionAddress("glDepthRange")) != 0L ? 1 : 0) & ((this.glDepthMask = GLContext.getFunctionAddress("glDepthMask")) != 0L ? 1 : 0) & ((this.glDepthFunc = GLContext.getFunctionAddress("glDepthFunc")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glFeedbackBuffer = GLContext.getFunctionAddress("glFeedbackBuffer")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetPixelMapfv = GLContext.getFunctionAddress("glGetPixelMapfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetPixelMapuiv = GLContext.getFunctionAddress("glGetPixelMapuiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetPixelMapusv = GLContext.getFunctionAddress("glGetPixelMapusv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetMaterialfv = GLContext.getFunctionAddress("glGetMaterialfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetMaterialiv = GLContext.getFunctionAddress("glGetMaterialiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetMapfv = GLContext.getFunctionAddress("glGetMapfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetMapdv = GLContext.getFunctionAddress("glGetMapdv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetMapiv = GLContext.getFunctionAddress("glGetMapiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetLightfv = GLContext.getFunctionAddress("glGetLightfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetLightiv = GLContext.getFunctionAddress("glGetLightiv")) != 0L) ? 1 : 0) & ((this.glGetError = GLContext.getFunctionAddress("glGetError")) != 0L ? 1 : 0) & ((this.glGetClipPlane = GLContext.getFunctionAddress("glGetClipPlane")) != 0L ? 1 : 0) & ((this.glGetBooleanv = GLContext.getFunctionAddress("glGetBooleanv")) != 0L ? 1 : 0) & ((this.glGetDoublev = GLContext.getFunctionAddress("glGetDoublev")) != 0L ? 1 : 0) & ((this.glGetFloatv = GLContext.getFunctionAddress("glGetFloatv")) != 0L ? 1 : 0) & ((this.glGetIntegerv = GLContext.getFunctionAddress("glGetIntegerv")) != 0L ? 1 : 0) & ((this.glGenTextures = GLContext.getFunctionAddress("glGenTextures")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glGenLists = GLContext.getFunctionAddress("glGenLists")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glFrustum = GLContext.getFunctionAddress("glFrustum")) != 0L) ? 1 : 0) & ((this.glFrontFace = GLContext.getFunctionAddress("glFrontFace")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glFogf = GLContext.getFunctionAddress("glFogf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glFogi = GLContext.getFunctionAddress("glFogi")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glFogfv = GLContext.getFunctionAddress("glFogfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glFogiv = GLContext.getFunctionAddress("glFogiv")) != 0L) ? 1 : 0) & ((this.glFlush = GLContext.getFunctionAddress("glFlush")) != 0L ? 1 : 0) & ((this.glFinish = GLContext.getFunctionAddress("glFinish")) != 0L ? 1 : 0) & ((this.glGetPointerv = GLContext.getFunctionAddress("glGetPointerv")) != 0L ? 1 : 0) & ((this.glIsEnabled = GLContext.getFunctionAddress("glIsEnabled")) != 0L ? 1 : 0) & ((this.glInterleavedArrays = GLContext.getFunctionAddress("glInterleavedArrays")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glInitNames = GLContext.getFunctionAddress("glInitNames")) != 0L) ? 1 : 0) & ((this.glHint = GLContext.getFunctionAddress("glHint")) != 0L ? 1 : 0) & ((this.glGetTexParameterfv = GLContext.getFunctionAddress("glGetTexParameterfv")) != 0L ? 1 : 0) & ((this.glGetTexParameteriv = GLContext.getFunctionAddress("glGetTexParameteriv")) != 0L ? 1 : 0) & ((this.glGetTexLevelParameterfv = GLContext.getFunctionAddress("glGetTexLevelParameterfv")) != 0L ? 1 : 0) & ((this.glGetTexLevelParameteriv = GLContext.getFunctionAddress("glGetTexLevelParameteriv")) != 0L ? 1 : 0) & ((this.glGetTexImage = GLContext.getFunctionAddress("glGetTexImage")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glGetTexGeniv = GLContext.getFunctionAddress("glGetTexGeniv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetTexGenfv = GLContext.getFunctionAddress("glGetTexGenfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glGetTexGendv = GLContext.getFunctionAddress("glGetTexGendv")) != 0L) ? 1 : 0) & ((this.glGetTexEnviv = GLContext.getFunctionAddress("glGetTexEnviv")) != 0L ? 1 : 0) & ((this.glGetTexEnvfv = GLContext.getFunctionAddress("glGetTexEnvfv")) != 0L ? 1 : 0) & ((this.glGetString = GLContext.getFunctionAddress("glGetString")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glGetPolygonStipple = GLContext.getFunctionAddress("glGetPolygonStipple")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glIsList = GLContext.getFunctionAddress("glIsList")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMaterialf = GLContext.getFunctionAddress("glMaterialf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMateriali = GLContext.getFunctionAddress("glMateriali")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMaterialfv = GLContext.getFunctionAddress("glMaterialfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMaterialiv = GLContext.getFunctionAddress("glMaterialiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMapGrid1f = GLContext.getFunctionAddress("glMapGrid1f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMapGrid1d = GLContext.getFunctionAddress("glMapGrid1d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMapGrid2f = GLContext.getFunctionAddress("glMapGrid2f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMapGrid2d = GLContext.getFunctionAddress("glMapGrid2d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMap2f = GLContext.getFunctionAddress("glMap2f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMap2d = GLContext.getFunctionAddress("glMap2d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMap1f = GLContext.getFunctionAddress("glMap1f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMap1d = GLContext.getFunctionAddress("glMap1d")) != 0L) ? 1 : 0) & ((this.glLogicOp = GLContext.getFunctionAddress("glLogicOp")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glLoadName = GLContext.getFunctionAddress("glLoadName")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLoadMatrixf = GLContext.getFunctionAddress("glLoadMatrixf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLoadMatrixd = GLContext.getFunctionAddress("glLoadMatrixd")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLoadIdentity = GLContext.getFunctionAddress("glLoadIdentity")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glListBase = GLContext.getFunctionAddress("glListBase")) != 0L) ? 1 : 0) & ((this.glLineWidth = GLContext.getFunctionAddress("glLineWidth")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glLineStipple = GLContext.getFunctionAddress("glLineStipple")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLightModelf = GLContext.getFunctionAddress("glLightModelf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLightModeli = GLContext.getFunctionAddress("glLightModeli")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLightModelfv = GLContext.getFunctionAddress("glLightModelfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLightModeliv = GLContext.getFunctionAddress("glLightModeliv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLightf = GLContext.getFunctionAddress("glLightf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLighti = GLContext.getFunctionAddress("glLighti")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLightfv = GLContext.getFunctionAddress("glLightfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLightiv = GLContext.getFunctionAddress("glLightiv")) != 0L) ? 1 : 0) & ((this.glIsTexture = GLContext.getFunctionAddress("glIsTexture")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glMatrixMode = GLContext.getFunctionAddress("glMatrixMode")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPolygonStipple = GLContext.getFunctionAddress("glPolygonStipple")) != 0L) ? 1 : 0) & ((this.glPolygonOffset = GLContext.getFunctionAddress("glPolygonOffset")) != 0L ? 1 : 0) & ((this.glPolygonMode = GLContext.getFunctionAddress("glPolygonMode")) != 0L ? 1 : 0) & ((this.glPointSize = GLContext.getFunctionAddress("glPointSize")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glPixelZoom = GLContext.getFunctionAddress("glPixelZoom")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPixelTransferf = GLContext.getFunctionAddress("glPixelTransferf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPixelTransferi = GLContext.getFunctionAddress("glPixelTransferi")) != 0L) ? 1 : 0) & ((this.glPixelStoref = GLContext.getFunctionAddress("glPixelStoref")) != 0L ? 1 : 0) & ((this.glPixelStorei = GLContext.getFunctionAddress("glPixelStorei")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glPixelMapfv = GLContext.getFunctionAddress("glPixelMapfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPixelMapuiv = GLContext.getFunctionAddress("glPixelMapuiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPixelMapusv = GLContext.getFunctionAddress("glPixelMapusv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPassThrough = GLContext.getFunctionAddress("glPassThrough")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glOrtho = GLContext.getFunctionAddress("glOrtho")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glNormalPointer = GLContext.getFunctionAddress("glNormalPointer")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glNormal3b = GLContext.getFunctionAddress("glNormal3b")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glNormal3f = GLContext.getFunctionAddress("glNormal3f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glNormal3d = GLContext.getFunctionAddress("glNormal3d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glNormal3i = GLContext.getFunctionAddress("glNormal3i")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glNewList = GLContext.getFunctionAddress("glNewList")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glEndList = GLContext.getFunctionAddress("glEndList")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultMatrixf = GLContext.getFunctionAddress("glMultMatrixf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultMatrixd = GLContext.getFunctionAddress("glMultMatrixd")) != 0L) ? 1 : 0) & ((this.glShadeModel = GLContext.getFunctionAddress("glShadeModel")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glSelectBuffer = GLContext.getFunctionAddress("glSelectBuffer")) != 0L) ? 1 : 0) & ((this.glScissor = GLContext.getFunctionAddress("glScissor")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glScalef = GLContext.getFunctionAddress("glScalef")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glScaled = GLContext.getFunctionAddress("glScaled")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRotatef = GLContext.getFunctionAddress("glRotatef")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRotated = GLContext.getFunctionAddress("glRotated")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRenderMode = GLContext.getFunctionAddress("glRenderMode")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRectf = GLContext.getFunctionAddress("glRectf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRectd = GLContext.getFunctionAddress("glRectd")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRecti = GLContext.getFunctionAddress("glRecti")) != 0L) ? 1 : 0) & ((this.glReadPixels = GLContext.getFunctionAddress("glReadPixels")) != 0L ? 1 : 0) & ((this.glReadBuffer = GLContext.getFunctionAddress("glReadBuffer")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glRasterPos2f = GLContext.getFunctionAddress("glRasterPos2f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRasterPos2d = GLContext.getFunctionAddress("glRasterPos2d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRasterPos2i = GLContext.getFunctionAddress("glRasterPos2i")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRasterPos3f = GLContext.getFunctionAddress("glRasterPos3f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRasterPos3d = GLContext.getFunctionAddress("glRasterPos3d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRasterPos3i = GLContext.getFunctionAddress("glRasterPos3i")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRasterPos4f = GLContext.getFunctionAddress("glRasterPos4f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRasterPos4d = GLContext.getFunctionAddress("glRasterPos4d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glRasterPos4i = GLContext.getFunctionAddress("glRasterPos4i")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPushName = GLContext.getFunctionAddress("glPushName")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPopName = GLContext.getFunctionAddress("glPopName")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPushMatrix = GLContext.getFunctionAddress("glPushMatrix")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPopMatrix = GLContext.getFunctionAddress("glPopMatrix")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPushClientAttrib = GLContext.getFunctionAddress("glPushClientAttrib")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPopClientAttrib = GLContext.getFunctionAddress("glPopClientAttrib")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPushAttrib = GLContext.getFunctionAddress("glPushAttrib")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glPopAttrib = GLContext.getFunctionAddress("glPopAttrib")) != 0L) ? 1 : 0) & ((this.glStencilFunc = GLContext.getFunctionAddress("glStencilFunc")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glVertexPointer = GLContext.getFunctionAddress("glVertexPointer")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertex2f = GLContext.getFunctionAddress("glVertex2f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertex2d = GLContext.getFunctionAddress("glVertex2d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertex2i = GLContext.getFunctionAddress("glVertex2i")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertex3f = GLContext.getFunctionAddress("glVertex3f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertex3d = GLContext.getFunctionAddress("glVertex3d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertex3i = GLContext.getFunctionAddress("glVertex3i")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertex4f = GLContext.getFunctionAddress("glVertex4f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertex4d = GLContext.getFunctionAddress("glVertex4d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertex4i = GLContext.getFunctionAddress("glVertex4i")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTranslatef = GLContext.getFunctionAddress("glTranslatef")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTranslated = GLContext.getFunctionAddress("glTranslated")) != 0L) ? 1 : 0) & ((this.glTexImage1D = GLContext.getFunctionAddress("glTexImage1D")) != 0L ? 1 : 0) & ((this.glTexImage2D = GLContext.getFunctionAddress("glTexImage2D")) != 0L ? 1 : 0) & ((this.glTexSubImage1D = GLContext.getFunctionAddress("glTexSubImage1D")) != 0L ? 1 : 0) & ((this.glTexSubImage2D = GLContext.getFunctionAddress("glTexSubImage2D")) != 0L ? 1 : 0) & ((this.glTexParameterf = GLContext.getFunctionAddress("glTexParameterf")) != 0L ? 1 : 0) & ((this.glTexParameteri = GLContext.getFunctionAddress("glTexParameteri")) != 0L ? 1 : 0) & ((this.glTexParameterfv = GLContext.getFunctionAddress("glTexParameterfv")) != 0L ? 1 : 0) & ((this.glTexParameteriv = GLContext.getFunctionAddress("glTexParameteriv")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glTexGenf = GLContext.getFunctionAddress("glTexGenf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexGend = GLContext.getFunctionAddress("glTexGend")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexGenfv = GLContext.getFunctionAddress("glTexGenfv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexGendv = GLContext.getFunctionAddress("glTexGendv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexGeni = GLContext.getFunctionAddress("glTexGeni")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexGeniv = GLContext.getFunctionAddress("glTexGeniv")) != 0L) ? 1 : 0) & ((this.glTexEnvf = GLContext.getFunctionAddress("glTexEnvf")) != 0L ? 1 : 0) & ((this.glTexEnvi = GLContext.getFunctionAddress("glTexEnvi")) != 0L ? 1 : 0) & ((this.glTexEnvfv = GLContext.getFunctionAddress("glTexEnvfv")) != 0L ? 1 : 0) & ((this.glTexEnviv = GLContext.getFunctionAddress("glTexEnviv")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoordPointer = GLContext.getFunctionAddress("glTexCoordPointer")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoord1f = GLContext.getFunctionAddress("glTexCoord1f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoord1d = GLContext.getFunctionAddress("glTexCoord1d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoord2f = GLContext.getFunctionAddress("glTexCoord2f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoord2d = GLContext.getFunctionAddress("glTexCoord2d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoord3f = GLContext.getFunctionAddress("glTexCoord3f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoord3d = GLContext.getFunctionAddress("glTexCoord3d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoord4f = GLContext.getFunctionAddress("glTexCoord4f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoord4d = GLContext.getFunctionAddress("glTexCoord4d")) != 0L) ? 1 : 0) & ((this.glStencilOp = GLContext.getFunctionAddress("glStencilOp")) != 0L ? 1 : 0) & ((this.glStencilMask = GLContext.getFunctionAddress("glStencilMask")) != 0L ? 1 : 0) & ((this.glViewport = GLContext.getFunctionAddress("glViewport")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL12_initNativeFunctionAddresses()
/*      */   {
/* 4202 */     return ((this.glDrawRangeElements = GLContext.getFunctionAddress("glDrawRangeElements")) != 0L ? 1 : 0) & ((this.glTexImage3D = GLContext.getFunctionAddress("glTexImage3D")) != 0L ? 1 : 0) & ((this.glTexSubImage3D = GLContext.getFunctionAddress("glTexSubImage3D")) != 0L ? 1 : 0) & ((this.glCopyTexSubImage3D = GLContext.getFunctionAddress("glCopyTexSubImage3D")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL13_initNativeFunctionAddresses(boolean forwardCompatible)
/*      */   {
/* 4210 */     return ((this.glActiveTexture = GLContext.getFunctionAddress("glActiveTexture")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glClientActiveTexture = GLContext.getFunctionAddress("glClientActiveTexture")) != 0L) ? 1 : 0) & ((this.glCompressedTexImage1D = GLContext.getFunctionAddress("glCompressedTexImage1D")) != 0L ? 1 : 0) & ((this.glCompressedTexImage2D = GLContext.getFunctionAddress("glCompressedTexImage2D")) != 0L ? 1 : 0) & ((this.glCompressedTexImage3D = GLContext.getFunctionAddress("glCompressedTexImage3D")) != 0L ? 1 : 0) & ((this.glCompressedTexSubImage1D = GLContext.getFunctionAddress("glCompressedTexSubImage1D")) != 0L ? 1 : 0) & ((this.glCompressedTexSubImage2D = GLContext.getFunctionAddress("glCompressedTexSubImage2D")) != 0L ? 1 : 0) & ((this.glCompressedTexSubImage3D = GLContext.getFunctionAddress("glCompressedTexSubImage3D")) != 0L ? 1 : 0) & ((this.glGetCompressedTexImage = GLContext.getFunctionAddress("glGetCompressedTexImage")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoord1f = GLContext.getFunctionAddress("glMultiTexCoord1f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoord1d = GLContext.getFunctionAddress("glMultiTexCoord1d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoord2f = GLContext.getFunctionAddress("glMultiTexCoord2f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoord2d = GLContext.getFunctionAddress("glMultiTexCoord2d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoord3f = GLContext.getFunctionAddress("glMultiTexCoord3f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoord3d = GLContext.getFunctionAddress("glMultiTexCoord3d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoord4f = GLContext.getFunctionAddress("glMultiTexCoord4f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoord4d = GLContext.getFunctionAddress("glMultiTexCoord4d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLoadTransposeMatrixf = GLContext.getFunctionAddress("glLoadTransposeMatrixf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glLoadTransposeMatrixd = GLContext.getFunctionAddress("glLoadTransposeMatrixd")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultTransposeMatrixf = GLContext.getFunctionAddress("glMultTransposeMatrixf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultTransposeMatrixd = GLContext.getFunctionAddress("glMultTransposeMatrixd")) != 0L) ? 1 : 0) & ((this.glSampleCoverage = GLContext.getFunctionAddress("glSampleCoverage")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL14_initNativeFunctionAddresses(boolean forwardCompatible)
/*      */   {
/* 4236 */     return ((this.glBlendEquation = GLContext.getFunctionAddress("glBlendEquation")) != 0L ? 1 : 0) & ((this.glBlendColor = GLContext.getFunctionAddress("glBlendColor")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glFogCoordf = GLContext.getFunctionAddress("glFogCoordf")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glFogCoordd = GLContext.getFunctionAddress("glFogCoordd")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glFogCoordPointer = GLContext.getFunctionAddress("glFogCoordPointer")) != 0L) ? 1 : 0) & ((this.glMultiDrawArrays = GLContext.getFunctionAddress("glMultiDrawArrays")) != 0L ? 1 : 0) & ((this.glPointParameteri = GLContext.getFunctionAddress("glPointParameteri")) != 0L ? 1 : 0) & ((this.glPointParameterf = GLContext.getFunctionAddress("glPointParameterf")) != 0L ? 1 : 0) & ((this.glPointParameteriv = GLContext.getFunctionAddress("glPointParameteriv")) != 0L ? 1 : 0) & ((this.glPointParameterfv = GLContext.getFunctionAddress("glPointParameterfv")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glSecondaryColor3b = GLContext.getFunctionAddress("glSecondaryColor3b")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glSecondaryColor3f = GLContext.getFunctionAddress("glSecondaryColor3f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glSecondaryColor3d = GLContext.getFunctionAddress("glSecondaryColor3d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glSecondaryColor3ub = GLContext.getFunctionAddress("glSecondaryColor3ub")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glSecondaryColorPointer = GLContext.getFunctionAddress("glSecondaryColorPointer")) != 0L) ? 1 : 0) & ((this.glBlendFuncSeparate = GLContext.getFunctionAddress("glBlendFuncSeparate")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos2f = GLContext.getFunctionAddress("glWindowPos2f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos2d = GLContext.getFunctionAddress("glWindowPos2d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos2i = GLContext.getFunctionAddress("glWindowPos2i")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos3f = GLContext.getFunctionAddress("glWindowPos3f")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos3d = GLContext.getFunctionAddress("glWindowPos3d")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glWindowPos3i = GLContext.getFunctionAddress("glWindowPos3i")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL15_initNativeFunctionAddresses()
/*      */   {
/* 4262 */     return ((this.glBindBuffer = GLContext.getFunctionAddress("glBindBuffer")) != 0L ? 1 : 0) & ((this.glDeleteBuffers = GLContext.getFunctionAddress("glDeleteBuffers")) != 0L ? 1 : 0) & ((this.glGenBuffers = GLContext.getFunctionAddress("glGenBuffers")) != 0L ? 1 : 0) & ((this.glIsBuffer = GLContext.getFunctionAddress("glIsBuffer")) != 0L ? 1 : 0) & ((this.glBufferData = GLContext.getFunctionAddress("glBufferData")) != 0L ? 1 : 0) & ((this.glBufferSubData = GLContext.getFunctionAddress("glBufferSubData")) != 0L ? 1 : 0) & ((this.glGetBufferSubData = GLContext.getFunctionAddress("glGetBufferSubData")) != 0L ? 1 : 0) & ((this.glMapBuffer = GLContext.getFunctionAddress("glMapBuffer")) != 0L ? 1 : 0) & ((this.glUnmapBuffer = GLContext.getFunctionAddress("glUnmapBuffer")) != 0L ? 1 : 0) & ((this.glGetBufferParameteriv = GLContext.getFunctionAddress("glGetBufferParameteriv")) != 0L ? 1 : 0) & ((this.glGetBufferPointerv = GLContext.getFunctionAddress("glGetBufferPointerv")) != 0L ? 1 : 0) & ((this.glGenQueries = GLContext.getFunctionAddress("glGenQueries")) != 0L ? 1 : 0) & ((this.glDeleteQueries = GLContext.getFunctionAddress("glDeleteQueries")) != 0L ? 1 : 0) & ((this.glIsQuery = GLContext.getFunctionAddress("glIsQuery")) != 0L ? 1 : 0) & ((this.glBeginQuery = GLContext.getFunctionAddress("glBeginQuery")) != 0L ? 1 : 0) & ((this.glEndQuery = GLContext.getFunctionAddress("glEndQuery")) != 0L ? 1 : 0) & ((this.glGetQueryiv = GLContext.getFunctionAddress("glGetQueryiv")) != 0L ? 1 : 0) & ((this.glGetQueryObjectiv = GLContext.getFunctionAddress("glGetQueryObjectiv")) != 0L ? 1 : 0) & ((this.glGetQueryObjectuiv = GLContext.getFunctionAddress("glGetQueryObjectuiv")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL20_initNativeFunctionAddresses()
/*      */   {
/* 4285 */     return ((this.glShaderSource = GLContext.getFunctionAddress("glShaderSource")) != 0L ? 1 : 0) & ((this.glCreateShader = GLContext.getFunctionAddress("glCreateShader")) != 0L ? 1 : 0) & ((this.glIsShader = GLContext.getFunctionAddress("glIsShader")) != 0L ? 1 : 0) & ((this.glCompileShader = GLContext.getFunctionAddress("glCompileShader")) != 0L ? 1 : 0) & ((this.glDeleteShader = GLContext.getFunctionAddress("glDeleteShader")) != 0L ? 1 : 0) & ((this.glCreateProgram = GLContext.getFunctionAddress("glCreateProgram")) != 0L ? 1 : 0) & ((this.glIsProgram = GLContext.getFunctionAddress("glIsProgram")) != 0L ? 1 : 0) & ((this.glAttachShader = GLContext.getFunctionAddress("glAttachShader")) != 0L ? 1 : 0) & ((this.glDetachShader = GLContext.getFunctionAddress("glDetachShader")) != 0L ? 1 : 0) & ((this.glLinkProgram = GLContext.getFunctionAddress("glLinkProgram")) != 0L ? 1 : 0) & ((this.glUseProgram = GLContext.getFunctionAddress("glUseProgram")) != 0L ? 1 : 0) & ((this.glValidateProgram = GLContext.getFunctionAddress("glValidateProgram")) != 0L ? 1 : 0) & ((this.glDeleteProgram = GLContext.getFunctionAddress("glDeleteProgram")) != 0L ? 1 : 0) & ((this.glUniform1f = GLContext.getFunctionAddress("glUniform1f")) != 0L ? 1 : 0) & ((this.glUniform2f = GLContext.getFunctionAddress("glUniform2f")) != 0L ? 1 : 0) & ((this.glUniform3f = GLContext.getFunctionAddress("glUniform3f")) != 0L ? 1 : 0) & ((this.glUniform4f = GLContext.getFunctionAddress("glUniform4f")) != 0L ? 1 : 0) & ((this.glUniform1i = GLContext.getFunctionAddress("glUniform1i")) != 0L ? 1 : 0) & ((this.glUniform2i = GLContext.getFunctionAddress("glUniform2i")) != 0L ? 1 : 0) & ((this.glUniform3i = GLContext.getFunctionAddress("glUniform3i")) != 0L ? 1 : 0) & ((this.glUniform4i = GLContext.getFunctionAddress("glUniform4i")) != 0L ? 1 : 0) & ((this.glUniform1fv = GLContext.getFunctionAddress("glUniform1fv")) != 0L ? 1 : 0) & ((this.glUniform2fv = GLContext.getFunctionAddress("glUniform2fv")) != 0L ? 1 : 0) & ((this.glUniform3fv = GLContext.getFunctionAddress("glUniform3fv")) != 0L ? 1 : 0) & ((this.glUniform4fv = GLContext.getFunctionAddress("glUniform4fv")) != 0L ? 1 : 0) & ((this.glUniform1iv = GLContext.getFunctionAddress("glUniform1iv")) != 0L ? 1 : 0) & ((this.glUniform2iv = GLContext.getFunctionAddress("glUniform2iv")) != 0L ? 1 : 0) & ((this.glUniform3iv = GLContext.getFunctionAddress("glUniform3iv")) != 0L ? 1 : 0) & ((this.glUniform4iv = GLContext.getFunctionAddress("glUniform4iv")) != 0L ? 1 : 0) & ((this.glUniformMatrix2fv = GLContext.getFunctionAddress("glUniformMatrix2fv")) != 0L ? 1 : 0) & ((this.glUniformMatrix3fv = GLContext.getFunctionAddress("glUniformMatrix3fv")) != 0L ? 1 : 0) & ((this.glUniformMatrix4fv = GLContext.getFunctionAddress("glUniformMatrix4fv")) != 0L ? 1 : 0) & ((this.glGetShaderiv = GLContext.getFunctionAddress("glGetShaderiv")) != 0L ? 1 : 0) & ((this.glGetProgramiv = GLContext.getFunctionAddress("glGetProgramiv")) != 0L ? 1 : 0) & ((this.glGetShaderInfoLog = GLContext.getFunctionAddress("glGetShaderInfoLog")) != 0L ? 1 : 0) & ((this.glGetProgramInfoLog = GLContext.getFunctionAddress("glGetProgramInfoLog")) != 0L ? 1 : 0) & ((this.glGetAttachedShaders = GLContext.getFunctionAddress("glGetAttachedShaders")) != 0L ? 1 : 0) & ((this.glGetUniformLocation = GLContext.getFunctionAddress("glGetUniformLocation")) != 0L ? 1 : 0) & ((this.glGetActiveUniform = GLContext.getFunctionAddress("glGetActiveUniform")) != 0L ? 1 : 0) & ((this.glGetUniformfv = GLContext.getFunctionAddress("glGetUniformfv")) != 0L ? 1 : 0) & ((this.glGetUniformiv = GLContext.getFunctionAddress("glGetUniformiv")) != 0L ? 1 : 0) & ((this.glGetShaderSource = GLContext.getFunctionAddress("glGetShaderSource")) != 0L ? 1 : 0) & ((this.glVertexAttrib1s = GLContext.getFunctionAddress("glVertexAttrib1s")) != 0L ? 1 : 0) & ((this.glVertexAttrib1f = GLContext.getFunctionAddress("glVertexAttrib1f")) != 0L ? 1 : 0) & ((this.glVertexAttrib1d = GLContext.getFunctionAddress("glVertexAttrib1d")) != 0L ? 1 : 0) & ((this.glVertexAttrib2s = GLContext.getFunctionAddress("glVertexAttrib2s")) != 0L ? 1 : 0) & ((this.glVertexAttrib2f = GLContext.getFunctionAddress("glVertexAttrib2f")) != 0L ? 1 : 0) & ((this.glVertexAttrib2d = GLContext.getFunctionAddress("glVertexAttrib2d")) != 0L ? 1 : 0) & ((this.glVertexAttrib3s = GLContext.getFunctionAddress("glVertexAttrib3s")) != 0L ? 1 : 0) & ((this.glVertexAttrib3f = GLContext.getFunctionAddress("glVertexAttrib3f")) != 0L ? 1 : 0) & ((this.glVertexAttrib3d = GLContext.getFunctionAddress("glVertexAttrib3d")) != 0L ? 1 : 0) & ((this.glVertexAttrib4s = GLContext.getFunctionAddress("glVertexAttrib4s")) != 0L ? 1 : 0) & ((this.glVertexAttrib4f = GLContext.getFunctionAddress("glVertexAttrib4f")) != 0L ? 1 : 0) & ((this.glVertexAttrib4d = GLContext.getFunctionAddress("glVertexAttrib4d")) != 0L ? 1 : 0) & ((this.glVertexAttrib4Nub = GLContext.getFunctionAddress("glVertexAttrib4Nub")) != 0L ? 1 : 0) & ((this.glVertexAttribPointer = GLContext.getFunctionAddress("glVertexAttribPointer")) != 0L ? 1 : 0) & ((this.glEnableVertexAttribArray = GLContext.getFunctionAddress("glEnableVertexAttribArray")) != 0L ? 1 : 0) & ((this.glDisableVertexAttribArray = GLContext.getFunctionAddress("glDisableVertexAttribArray")) != 0L ? 1 : 0) & ((this.glGetVertexAttribfv = GLContext.getFunctionAddress("glGetVertexAttribfv")) != 0L ? 1 : 0) & ((this.glGetVertexAttribdv = GLContext.getFunctionAddress("glGetVertexAttribdv")) != 0L ? 1 : 0) & ((this.glGetVertexAttribiv = GLContext.getFunctionAddress("glGetVertexAttribiv")) != 0L ? 1 : 0) & ((this.glGetVertexAttribPointerv = GLContext.getFunctionAddress("glGetVertexAttribPointerv")) != 0L ? 1 : 0) & ((this.glBindAttribLocation = GLContext.getFunctionAddress("glBindAttribLocation")) != 0L ? 1 : 0) & ((this.glGetActiveAttrib = GLContext.getFunctionAddress("glGetActiveAttrib")) != 0L ? 1 : 0) & ((this.glGetAttribLocation = GLContext.getFunctionAddress("glGetAttribLocation")) != 0L ? 1 : 0) & ((this.glDrawBuffers = GLContext.getFunctionAddress("glDrawBuffers")) != 0L ? 1 : 0) & ((this.glStencilOpSeparate = GLContext.getFunctionAddress("glStencilOpSeparate")) != 0L ? 1 : 0) & ((this.glStencilFuncSeparate = GLContext.getFunctionAddress("glStencilFuncSeparate")) != 0L ? 1 : 0) & ((this.glStencilMaskSeparate = GLContext.getFunctionAddress("glStencilMaskSeparate")) != 0L ? 1 : 0) & ((this.glBlendEquationSeparate = GLContext.getFunctionAddress("glBlendEquationSeparate")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL21_initNativeFunctionAddresses()
/*      */   {
/* 4359 */     return ((this.glUniformMatrix2x3fv = GLContext.getFunctionAddress("glUniformMatrix2x3fv")) != 0L ? 1 : 0) & ((this.glUniformMatrix3x2fv = GLContext.getFunctionAddress("glUniformMatrix3x2fv")) != 0L ? 1 : 0) & ((this.glUniformMatrix2x4fv = GLContext.getFunctionAddress("glUniformMatrix2x4fv")) != 0L ? 1 : 0) & ((this.glUniformMatrix4x2fv = GLContext.getFunctionAddress("glUniformMatrix4x2fv")) != 0L ? 1 : 0) & ((this.glUniformMatrix3x4fv = GLContext.getFunctionAddress("glUniformMatrix3x4fv")) != 0L ? 1 : 0) & ((this.glUniformMatrix4x3fv = GLContext.getFunctionAddress("glUniformMatrix4x3fv")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL30_initNativeFunctionAddresses()
/*      */   {
/* 4369 */     return ((this.glGetStringi = GLContext.getFunctionAddress("glGetStringi")) != 0L ? 1 : 0) & ((this.glClearBufferfv = GLContext.getFunctionAddress("glClearBufferfv")) != 0L ? 1 : 0) & ((this.glClearBufferiv = GLContext.getFunctionAddress("glClearBufferiv")) != 0L ? 1 : 0) & ((this.glClearBufferuiv = GLContext.getFunctionAddress("glClearBufferuiv")) != 0L ? 1 : 0) & ((this.glClearBufferfi = GLContext.getFunctionAddress("glClearBufferfi")) != 0L ? 1 : 0) & ((this.glVertexAttribI1i = GLContext.getFunctionAddress("glVertexAttribI1i")) != 0L ? 1 : 0) & ((this.glVertexAttribI2i = GLContext.getFunctionAddress("glVertexAttribI2i")) != 0L ? 1 : 0) & ((this.glVertexAttribI3i = GLContext.getFunctionAddress("glVertexAttribI3i")) != 0L ? 1 : 0) & ((this.glVertexAttribI4i = GLContext.getFunctionAddress("glVertexAttribI4i")) != 0L ? 1 : 0) & ((this.glVertexAttribI1ui = GLContext.getFunctionAddress("glVertexAttribI1ui")) != 0L ? 1 : 0) & ((this.glVertexAttribI2ui = GLContext.getFunctionAddress("glVertexAttribI2ui")) != 0L ? 1 : 0) & ((this.glVertexAttribI3ui = GLContext.getFunctionAddress("glVertexAttribI3ui")) != 0L ? 1 : 0) & ((this.glVertexAttribI4ui = GLContext.getFunctionAddress("glVertexAttribI4ui")) != 0L ? 1 : 0) & ((this.glVertexAttribI1iv = GLContext.getFunctionAddress("glVertexAttribI1iv")) != 0L ? 1 : 0) & ((this.glVertexAttribI2iv = GLContext.getFunctionAddress("glVertexAttribI2iv")) != 0L ? 1 : 0) & ((this.glVertexAttribI3iv = GLContext.getFunctionAddress("glVertexAttribI3iv")) != 0L ? 1 : 0) & ((this.glVertexAttribI4iv = GLContext.getFunctionAddress("glVertexAttribI4iv")) != 0L ? 1 : 0) & ((this.glVertexAttribI1uiv = GLContext.getFunctionAddress("glVertexAttribI1uiv")) != 0L ? 1 : 0) & ((this.glVertexAttribI2uiv = GLContext.getFunctionAddress("glVertexAttribI2uiv")) != 0L ? 1 : 0) & ((this.glVertexAttribI3uiv = GLContext.getFunctionAddress("glVertexAttribI3uiv")) != 0L ? 1 : 0) & ((this.glVertexAttribI4uiv = GLContext.getFunctionAddress("glVertexAttribI4uiv")) != 0L ? 1 : 0) & ((this.glVertexAttribI4bv = GLContext.getFunctionAddress("glVertexAttribI4bv")) != 0L ? 1 : 0) & ((this.glVertexAttribI4sv = GLContext.getFunctionAddress("glVertexAttribI4sv")) != 0L ? 1 : 0) & ((this.glVertexAttribI4ubv = GLContext.getFunctionAddress("glVertexAttribI4ubv")) != 0L ? 1 : 0) & ((this.glVertexAttribI4usv = GLContext.getFunctionAddress("glVertexAttribI4usv")) != 0L ? 1 : 0) & ((this.glVertexAttribIPointer = GLContext.getFunctionAddress("glVertexAttribIPointer")) != 0L ? 1 : 0) & ((this.glGetVertexAttribIiv = GLContext.getFunctionAddress("glGetVertexAttribIiv")) != 0L ? 1 : 0) & ((this.glGetVertexAttribIuiv = GLContext.getFunctionAddress("glGetVertexAttribIuiv")) != 0L ? 1 : 0) & ((this.glUniform1ui = GLContext.getFunctionAddress("glUniform1ui")) != 0L ? 1 : 0) & ((this.glUniform2ui = GLContext.getFunctionAddress("glUniform2ui")) != 0L ? 1 : 0) & ((this.glUniform3ui = GLContext.getFunctionAddress("glUniform3ui")) != 0L ? 1 : 0) & ((this.glUniform4ui = GLContext.getFunctionAddress("glUniform4ui")) != 0L ? 1 : 0) & ((this.glUniform1uiv = GLContext.getFunctionAddress("glUniform1uiv")) != 0L ? 1 : 0) & ((this.glUniform2uiv = GLContext.getFunctionAddress("glUniform2uiv")) != 0L ? 1 : 0) & ((this.glUniform3uiv = GLContext.getFunctionAddress("glUniform3uiv")) != 0L ? 1 : 0) & ((this.glUniform4uiv = GLContext.getFunctionAddress("glUniform4uiv")) != 0L ? 1 : 0) & ((this.glGetUniformuiv = GLContext.getFunctionAddress("glGetUniformuiv")) != 0L ? 1 : 0) & ((this.glBindFragDataLocation = GLContext.getFunctionAddress("glBindFragDataLocation")) != 0L ? 1 : 0) & ((this.glGetFragDataLocation = GLContext.getFunctionAddress("glGetFragDataLocation")) != 0L ? 1 : 0) & ((this.glBeginConditionalRender = GLContext.getFunctionAddress("glBeginConditionalRender")) != 0L ? 1 : 0) & ((this.glEndConditionalRender = GLContext.getFunctionAddress("glEndConditionalRender")) != 0L ? 1 : 0) & ((this.glMapBufferRange = GLContext.getFunctionAddress("glMapBufferRange")) != 0L ? 1 : 0) & ((this.glFlushMappedBufferRange = GLContext.getFunctionAddress("glFlushMappedBufferRange")) != 0L ? 1 : 0) & ((this.glClampColor = GLContext.getFunctionAddress("glClampColor")) != 0L ? 1 : 0) & ((this.glIsRenderbuffer = GLContext.getFunctionAddress("glIsRenderbuffer")) != 0L ? 1 : 0) & ((this.glBindRenderbuffer = GLContext.getFunctionAddress("glBindRenderbuffer")) != 0L ? 1 : 0) & ((this.glDeleteRenderbuffers = GLContext.getFunctionAddress("glDeleteRenderbuffers")) != 0L ? 1 : 0) & ((this.glGenRenderbuffers = GLContext.getFunctionAddress("glGenRenderbuffers")) != 0L ? 1 : 0) & ((this.glRenderbufferStorage = GLContext.getFunctionAddress("glRenderbufferStorage")) != 0L ? 1 : 0) & ((this.glGetRenderbufferParameteriv = GLContext.getFunctionAddress("glGetRenderbufferParameteriv")) != 0L ? 1 : 0) & ((this.glIsFramebuffer = GLContext.getFunctionAddress("glIsFramebuffer")) != 0L ? 1 : 0) & ((this.glBindFramebuffer = GLContext.getFunctionAddress("glBindFramebuffer")) != 0L ? 1 : 0) & ((this.glDeleteFramebuffers = GLContext.getFunctionAddress("glDeleteFramebuffers")) != 0L ? 1 : 0) & ((this.glGenFramebuffers = GLContext.getFunctionAddress("glGenFramebuffers")) != 0L ? 1 : 0) & ((this.glCheckFramebufferStatus = GLContext.getFunctionAddress("glCheckFramebufferStatus")) != 0L ? 1 : 0) & ((this.glFramebufferTexture1D = GLContext.getFunctionAddress("glFramebufferTexture1D")) != 0L ? 1 : 0) & ((this.glFramebufferTexture2D = GLContext.getFunctionAddress("glFramebufferTexture2D")) != 0L ? 1 : 0) & ((this.glFramebufferTexture3D = GLContext.getFunctionAddress("glFramebufferTexture3D")) != 0L ? 1 : 0) & ((this.glFramebufferRenderbuffer = GLContext.getFunctionAddress("glFramebufferRenderbuffer")) != 0L ? 1 : 0) & ((this.glGetFramebufferAttachmentParameteriv = GLContext.getFunctionAddress("glGetFramebufferAttachmentParameteriv")) != 0L ? 1 : 0) & ((this.glGenerateMipmap = GLContext.getFunctionAddress("glGenerateMipmap")) != 0L ? 1 : 0) & ((this.glRenderbufferStorageMultisample = GLContext.getFunctionAddress("glRenderbufferStorageMultisample")) != 0L ? 1 : 0) & ((this.glBlitFramebuffer = GLContext.getFunctionAddress("glBlitFramebuffer")) != 0L ? 1 : 0) & ((this.glTexParameterIiv = GLContext.getFunctionAddress("glTexParameterIiv")) != 0L ? 1 : 0) & ((this.glTexParameterIuiv = GLContext.getFunctionAddress("glTexParameterIuiv")) != 0L ? 1 : 0) & ((this.glGetTexParameterIiv = GLContext.getFunctionAddress("glGetTexParameterIiv")) != 0L ? 1 : 0) & ((this.glGetTexParameterIuiv = GLContext.getFunctionAddress("glGetTexParameterIuiv")) != 0L ? 1 : 0) & ((this.glFramebufferTextureLayer = GLContext.getFunctionAddress("glFramebufferTextureLayer")) != 0L ? 1 : 0) & ((this.glColorMaski = GLContext.getFunctionAddress("glColorMaski")) != 0L ? 1 : 0) & ((this.glGetBooleani_v = GLContext.getFunctionAddress("glGetBooleani_v")) != 0L ? 1 : 0) & ((this.glGetIntegeri_v = GLContext.getFunctionAddress("glGetIntegeri_v")) != 0L ? 1 : 0) & ((this.glEnablei = GLContext.getFunctionAddress("glEnablei")) != 0L ? 1 : 0) & ((this.glDisablei = GLContext.getFunctionAddress("glDisablei")) != 0L ? 1 : 0) & ((this.glIsEnabledi = GLContext.getFunctionAddress("glIsEnabledi")) != 0L ? 1 : 0) & ((this.glBindBufferRange = GLContext.getFunctionAddress("glBindBufferRange")) != 0L ? 1 : 0) & ((this.glBindBufferBase = GLContext.getFunctionAddress("glBindBufferBase")) != 0L ? 1 : 0) & ((this.glBeginTransformFeedback = GLContext.getFunctionAddress("glBeginTransformFeedback")) != 0L ? 1 : 0) & ((this.glEndTransformFeedback = GLContext.getFunctionAddress("glEndTransformFeedback")) != 0L ? 1 : 0) & ((this.glTransformFeedbackVaryings = GLContext.getFunctionAddress("glTransformFeedbackVaryings")) != 0L ? 1 : 0) & ((this.glGetTransformFeedbackVarying = GLContext.getFunctionAddress("glGetTransformFeedbackVarying")) != 0L ? 1 : 0) & ((this.glBindVertexArray = GLContext.getFunctionAddress("glBindVertexArray")) != 0L ? 1 : 0) & ((this.glDeleteVertexArrays = GLContext.getFunctionAddress("glDeleteVertexArrays")) != 0L ? 1 : 0) & ((this.glGenVertexArrays = GLContext.getFunctionAddress("glGenVertexArrays")) != 0L ? 1 : 0) & ((this.glIsVertexArray = GLContext.getFunctionAddress("glIsVertexArray")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL31_initNativeFunctionAddresses()
/*      */   {
/* 4457 */     return ((this.glDrawArraysInstanced = GLContext.getFunctionAddress("glDrawArraysInstanced")) != 0L ? 1 : 0) & ((this.glDrawElementsInstanced = GLContext.getFunctionAddress("glDrawElementsInstanced")) != 0L ? 1 : 0) & ((this.glCopyBufferSubData = GLContext.getFunctionAddress("glCopyBufferSubData")) != 0L ? 1 : 0) & ((this.glPrimitiveRestartIndex = GLContext.getFunctionAddress("glPrimitiveRestartIndex")) != 0L ? 1 : 0) & ((this.glTexBuffer = GLContext.getFunctionAddress("glTexBuffer")) != 0L ? 1 : 0) & ((this.glGetUniformIndices = GLContext.getFunctionAddress("glGetUniformIndices")) != 0L ? 1 : 0) & ((this.glGetActiveUniformsiv = GLContext.getFunctionAddress("glGetActiveUniformsiv")) != 0L ? 1 : 0) & ((this.glGetActiveUniformName = GLContext.getFunctionAddress("glGetActiveUniformName")) != 0L ? 1 : 0) & ((this.glGetUniformBlockIndex = GLContext.getFunctionAddress("glGetUniformBlockIndex")) != 0L ? 1 : 0) & ((this.glGetActiveUniformBlockiv = GLContext.getFunctionAddress("glGetActiveUniformBlockiv")) != 0L ? 1 : 0) & ((this.glGetActiveUniformBlockName = GLContext.getFunctionAddress("glGetActiveUniformBlockName")) != 0L ? 1 : 0) & ((this.glUniformBlockBinding = GLContext.getFunctionAddress("glUniformBlockBinding")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL32_initNativeFunctionAddresses()
/*      */   {
/* 4473 */     return ((this.glGetBufferParameteri64v = GLContext.getFunctionAddress("glGetBufferParameteri64v")) != 0L ? 1 : 0) & ((this.glDrawElementsBaseVertex = GLContext.getFunctionAddress("glDrawElementsBaseVertex")) != 0L ? 1 : 0) & ((this.glDrawRangeElementsBaseVertex = GLContext.getFunctionAddress("glDrawRangeElementsBaseVertex")) != 0L ? 1 : 0) & ((this.glDrawElementsInstancedBaseVertex = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertex")) != 0L ? 1 : 0) & ((this.glProvokingVertex = GLContext.getFunctionAddress("glProvokingVertex")) != 0L ? 1 : 0) & ((this.glTexImage2DMultisample = GLContext.getFunctionAddress("glTexImage2DMultisample")) != 0L ? 1 : 0) & ((this.glTexImage3DMultisample = GLContext.getFunctionAddress("glTexImage3DMultisample")) != 0L ? 1 : 0) & ((this.glGetMultisamplefv = GLContext.getFunctionAddress("glGetMultisamplefv")) != 0L ? 1 : 0) & ((this.glSampleMaski = GLContext.getFunctionAddress("glSampleMaski")) != 0L ? 1 : 0) & ((this.glFramebufferTexture = GLContext.getFunctionAddress("glFramebufferTexture")) != 0L ? 1 : 0) & ((this.glFenceSync = GLContext.getFunctionAddress("glFenceSync")) != 0L ? 1 : 0) & ((this.glIsSync = GLContext.getFunctionAddress("glIsSync")) != 0L ? 1 : 0) & ((this.glDeleteSync = GLContext.getFunctionAddress("glDeleteSync")) != 0L ? 1 : 0) & ((this.glClientWaitSync = GLContext.getFunctionAddress("glClientWaitSync")) != 0L ? 1 : 0) & ((this.glWaitSync = GLContext.getFunctionAddress("glWaitSync")) != 0L ? 1 : 0) & ((this.glGetInteger64v = GLContext.getFunctionAddress("glGetInteger64v")) != 0L ? 1 : 0) & 0x1 & (((this.glGetInteger64i_v = GLContext.getFunctionAddress("glGetInteger64i_v")) != 0L) || ((this.glGetSynciv = GLContext.getFunctionAddress("glGetSynciv")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL33_initNativeFunctionAddresses(boolean forwardCompatible)
/*      */   {
/* 4495 */     return ((this.glBindFragDataLocationIndexed = GLContext.getFunctionAddress("glBindFragDataLocationIndexed")) != 0L ? 1 : 0) & ((this.glGetFragDataIndex = GLContext.getFunctionAddress("glGetFragDataIndex")) != 0L ? 1 : 0) & ((this.glGenSamplers = GLContext.getFunctionAddress("glGenSamplers")) != 0L ? 1 : 0) & ((this.glDeleteSamplers = GLContext.getFunctionAddress("glDeleteSamplers")) != 0L ? 1 : 0) & ((this.glIsSampler = GLContext.getFunctionAddress("glIsSampler")) != 0L ? 1 : 0) & ((this.glBindSampler = GLContext.getFunctionAddress("glBindSampler")) != 0L ? 1 : 0) & ((this.glSamplerParameteri = GLContext.getFunctionAddress("glSamplerParameteri")) != 0L ? 1 : 0) & ((this.glSamplerParameterf = GLContext.getFunctionAddress("glSamplerParameterf")) != 0L ? 1 : 0) & ((this.glSamplerParameteriv = GLContext.getFunctionAddress("glSamplerParameteriv")) != 0L ? 1 : 0) & ((this.glSamplerParameterfv = GLContext.getFunctionAddress("glSamplerParameterfv")) != 0L ? 1 : 0) & ((this.glSamplerParameterIiv = GLContext.getFunctionAddress("glSamplerParameterIiv")) != 0L ? 1 : 0) & ((this.glSamplerParameterIuiv = GLContext.getFunctionAddress("glSamplerParameterIuiv")) != 0L ? 1 : 0) & ((this.glGetSamplerParameteriv = GLContext.getFunctionAddress("glGetSamplerParameteriv")) != 0L ? 1 : 0) & ((this.glGetSamplerParameterfv = GLContext.getFunctionAddress("glGetSamplerParameterfv")) != 0L ? 1 : 0) & ((this.glGetSamplerParameterIiv = GLContext.getFunctionAddress("glGetSamplerParameterIiv")) != 0L ? 1 : 0) & ((this.glGetSamplerParameterIuiv = GLContext.getFunctionAddress("glGetSamplerParameterIuiv")) != 0L ? 1 : 0) & ((this.glQueryCounter = GLContext.getFunctionAddress("glQueryCounter")) != 0L ? 1 : 0) & ((this.glGetQueryObjecti64v = GLContext.getFunctionAddress("glGetQueryObjecti64v")) != 0L ? 1 : 0) & ((this.glGetQueryObjectui64v = GLContext.getFunctionAddress("glGetQueryObjectui64v")) != 0L ? 1 : 0) & ((this.glVertexAttribDivisor = GLContext.getFunctionAddress("glVertexAttribDivisor")) != 0L ? 1 : 0) & ((forwardCompatible) || ((this.glVertexP2ui = GLContext.getFunctionAddress("glVertexP2ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexP3ui = GLContext.getFunctionAddress("glVertexP3ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexP4ui = GLContext.getFunctionAddress("glVertexP4ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexP2uiv = GLContext.getFunctionAddress("glVertexP2uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexP3uiv = GLContext.getFunctionAddress("glVertexP3uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexP4uiv = GLContext.getFunctionAddress("glVertexP4uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoordP1ui = GLContext.getFunctionAddress("glTexCoordP1ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoordP2ui = GLContext.getFunctionAddress("glTexCoordP2ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoordP3ui = GLContext.getFunctionAddress("glTexCoordP3ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoordP4ui = GLContext.getFunctionAddress("glTexCoordP4ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoordP1uiv = GLContext.getFunctionAddress("glTexCoordP1uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoordP2uiv = GLContext.getFunctionAddress("glTexCoordP2uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoordP3uiv = GLContext.getFunctionAddress("glTexCoordP3uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glTexCoordP4uiv = GLContext.getFunctionAddress("glTexCoordP4uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoordP1ui = GLContext.getFunctionAddress("glMultiTexCoordP1ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoordP2ui = GLContext.getFunctionAddress("glMultiTexCoordP2ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoordP3ui = GLContext.getFunctionAddress("glMultiTexCoordP3ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoordP4ui = GLContext.getFunctionAddress("glMultiTexCoordP4ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoordP1uiv = GLContext.getFunctionAddress("glMultiTexCoordP1uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoordP2uiv = GLContext.getFunctionAddress("glMultiTexCoordP2uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoordP3uiv = GLContext.getFunctionAddress("glMultiTexCoordP3uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glMultiTexCoordP4uiv = GLContext.getFunctionAddress("glMultiTexCoordP4uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glNormalP3ui = GLContext.getFunctionAddress("glNormalP3ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glNormalP3uiv = GLContext.getFunctionAddress("glNormalP3uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColorP3ui = GLContext.getFunctionAddress("glColorP3ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColorP4ui = GLContext.getFunctionAddress("glColorP4ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColorP3uiv = GLContext.getFunctionAddress("glColorP3uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glColorP4uiv = GLContext.getFunctionAddress("glColorP4uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glSecondaryColorP3ui = GLContext.getFunctionAddress("glSecondaryColorP3ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glSecondaryColorP3uiv = GLContext.getFunctionAddress("glSecondaryColorP3uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexAttribP1ui = GLContext.getFunctionAddress("glVertexAttribP1ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexAttribP2ui = GLContext.getFunctionAddress("glVertexAttribP2ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexAttribP3ui = GLContext.getFunctionAddress("glVertexAttribP3ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexAttribP4ui = GLContext.getFunctionAddress("glVertexAttribP4ui")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexAttribP1uiv = GLContext.getFunctionAddress("glVertexAttribP1uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexAttribP2uiv = GLContext.getFunctionAddress("glVertexAttribP2uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexAttribP3uiv = GLContext.getFunctionAddress("glVertexAttribP3uiv")) != 0L) ? 1 : 0) & ((forwardCompatible) || ((this.glVertexAttribP4uiv = GLContext.getFunctionAddress("glVertexAttribP4uiv")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL40_initNativeFunctionAddresses()
/*      */   {
/* 4557 */     return ((this.glBlendEquationi = GLContext.getFunctionAddress("glBlendEquationi")) != 0L ? 1 : 0) & ((this.glBlendEquationSeparatei = GLContext.getFunctionAddress("glBlendEquationSeparatei")) != 0L ? 1 : 0) & ((this.glBlendFunci = GLContext.getFunctionAddress("glBlendFunci")) != 0L ? 1 : 0) & ((this.glBlendFuncSeparatei = GLContext.getFunctionAddress("glBlendFuncSeparatei")) != 0L ? 1 : 0) & ((this.glDrawArraysIndirect = GLContext.getFunctionAddress("glDrawArraysIndirect")) != 0L ? 1 : 0) & ((this.glDrawElementsIndirect = GLContext.getFunctionAddress("glDrawElementsIndirect")) != 0L ? 1 : 0) & ((this.glUniform1d = GLContext.getFunctionAddress("glUniform1d")) != 0L ? 1 : 0) & ((this.glUniform2d = GLContext.getFunctionAddress("glUniform2d")) != 0L ? 1 : 0) & ((this.glUniform3d = GLContext.getFunctionAddress("glUniform3d")) != 0L ? 1 : 0) & ((this.glUniform4d = GLContext.getFunctionAddress("glUniform4d")) != 0L ? 1 : 0) & ((this.glUniform1dv = GLContext.getFunctionAddress("glUniform1dv")) != 0L ? 1 : 0) & ((this.glUniform2dv = GLContext.getFunctionAddress("glUniform2dv")) != 0L ? 1 : 0) & ((this.glUniform3dv = GLContext.getFunctionAddress("glUniform3dv")) != 0L ? 1 : 0) & ((this.glUniform4dv = GLContext.getFunctionAddress("glUniform4dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix2dv = GLContext.getFunctionAddress("glUniformMatrix2dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix3dv = GLContext.getFunctionAddress("glUniformMatrix3dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix4dv = GLContext.getFunctionAddress("glUniformMatrix4dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix2x3dv = GLContext.getFunctionAddress("glUniformMatrix2x3dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix2x4dv = GLContext.getFunctionAddress("glUniformMatrix2x4dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix3x2dv = GLContext.getFunctionAddress("glUniformMatrix3x2dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix3x4dv = GLContext.getFunctionAddress("glUniformMatrix3x4dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix4x2dv = GLContext.getFunctionAddress("glUniformMatrix4x2dv")) != 0L ? 1 : 0) & ((this.glUniformMatrix4x3dv = GLContext.getFunctionAddress("glUniformMatrix4x3dv")) != 0L ? 1 : 0) & ((this.glGetUniformdv = GLContext.getFunctionAddress("glGetUniformdv")) != 0L ? 1 : 0) & ((this.glMinSampleShading = GLContext.getFunctionAddress("glMinSampleShading")) != 0L ? 1 : 0) & ((this.glGetSubroutineUniformLocation = GLContext.getFunctionAddress("glGetSubroutineUniformLocation")) != 0L ? 1 : 0) & ((this.glGetSubroutineIndex = GLContext.getFunctionAddress("glGetSubroutineIndex")) != 0L ? 1 : 0) & ((this.glGetActiveSubroutineUniformiv = GLContext.getFunctionAddress("glGetActiveSubroutineUniformiv")) != 0L ? 1 : 0) & ((this.glGetActiveSubroutineUniformName = GLContext.getFunctionAddress("glGetActiveSubroutineUniformName")) != 0L ? 1 : 0) & ((this.glGetActiveSubroutineName = GLContext.getFunctionAddress("glGetActiveSubroutineName")) != 0L ? 1 : 0) & ((this.glUniformSubroutinesuiv = GLContext.getFunctionAddress("glUniformSubroutinesuiv")) != 0L ? 1 : 0) & ((this.glGetUniformSubroutineuiv = GLContext.getFunctionAddress("glGetUniformSubroutineuiv")) != 0L ? 1 : 0) & ((this.glGetProgramStageiv = GLContext.getFunctionAddress("glGetProgramStageiv")) != 0L ? 1 : 0) & ((this.glPatchParameteri = GLContext.getFunctionAddress("glPatchParameteri")) != 0L ? 1 : 0) & ((this.glPatchParameterfv = GLContext.getFunctionAddress("glPatchParameterfv")) != 0L ? 1 : 0) & ((this.glBindTransformFeedback = GLContext.getFunctionAddress("glBindTransformFeedback")) != 0L ? 1 : 0) & ((this.glDeleteTransformFeedbacks = GLContext.getFunctionAddress("glDeleteTransformFeedbacks")) != 0L ? 1 : 0) & ((this.glGenTransformFeedbacks = GLContext.getFunctionAddress("glGenTransformFeedbacks")) != 0L ? 1 : 0) & ((this.glIsTransformFeedback = GLContext.getFunctionAddress("glIsTransformFeedback")) != 0L ? 1 : 0) & ((this.glPauseTransformFeedback = GLContext.getFunctionAddress("glPauseTransformFeedback")) != 0L ? 1 : 0) & ((this.glResumeTransformFeedback = GLContext.getFunctionAddress("glResumeTransformFeedback")) != 0L ? 1 : 0) & ((this.glDrawTransformFeedback = GLContext.getFunctionAddress("glDrawTransformFeedback")) != 0L ? 1 : 0) & ((this.glDrawTransformFeedbackStream = GLContext.getFunctionAddress("glDrawTransformFeedbackStream")) != 0L ? 1 : 0) & ((this.glBeginQueryIndexed = GLContext.getFunctionAddress("glBeginQueryIndexed")) != 0L ? 1 : 0) & ((this.glEndQueryIndexed = GLContext.getFunctionAddress("glEndQueryIndexed")) != 0L ? 1 : 0) & ((this.glGetQueryIndexediv = GLContext.getFunctionAddress("glGetQueryIndexediv")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL41_initNativeFunctionAddresses()
/*      */   {
/* 4607 */     return ((this.glReleaseShaderCompiler = GLContext.getFunctionAddress("glReleaseShaderCompiler")) != 0L ? 1 : 0) & ((this.glShaderBinary = GLContext.getFunctionAddress("glShaderBinary")) != 0L ? 1 : 0) & ((this.glGetShaderPrecisionFormat = GLContext.getFunctionAddress("glGetShaderPrecisionFormat")) != 0L ? 1 : 0) & ((this.glDepthRangef = GLContext.getFunctionAddress("glDepthRangef")) != 0L ? 1 : 0) & ((this.glClearDepthf = GLContext.getFunctionAddress("glClearDepthf")) != 0L ? 1 : 0) & ((this.glGetProgramBinary = GLContext.getFunctionAddress("glGetProgramBinary")) != 0L ? 1 : 0) & ((this.glProgramBinary = GLContext.getFunctionAddress("glProgramBinary")) != 0L ? 1 : 0) & ((this.glProgramParameteri = GLContext.getFunctionAddress("glProgramParameteri")) != 0L ? 1 : 0) & ((this.glUseProgramStages = GLContext.getFunctionAddress("glUseProgramStages")) != 0L ? 1 : 0) & ((this.glActiveShaderProgram = GLContext.getFunctionAddress("glActiveShaderProgram")) != 0L ? 1 : 0) & ((this.glCreateShaderProgramv = GLContext.getFunctionAddress("glCreateShaderProgramv")) != 0L ? 1 : 0) & ((this.glBindProgramPipeline = GLContext.getFunctionAddress("glBindProgramPipeline")) != 0L ? 1 : 0) & ((this.glDeleteProgramPipelines = GLContext.getFunctionAddress("glDeleteProgramPipelines")) != 0L ? 1 : 0) & ((this.glGenProgramPipelines = GLContext.getFunctionAddress("glGenProgramPipelines")) != 0L ? 1 : 0) & ((this.glIsProgramPipeline = GLContext.getFunctionAddress("glIsProgramPipeline")) != 0L ? 1 : 0) & ((this.glGetProgramPipelineiv = GLContext.getFunctionAddress("glGetProgramPipelineiv")) != 0L ? 1 : 0) & ((this.glProgramUniform1i = GLContext.getFunctionAddress("glProgramUniform1i")) != 0L ? 1 : 0) & ((this.glProgramUniform2i = GLContext.getFunctionAddress("glProgramUniform2i")) != 0L ? 1 : 0) & ((this.glProgramUniform3i = GLContext.getFunctionAddress("glProgramUniform3i")) != 0L ? 1 : 0) & ((this.glProgramUniform4i = GLContext.getFunctionAddress("glProgramUniform4i")) != 0L ? 1 : 0) & ((this.glProgramUniform1f = GLContext.getFunctionAddress("glProgramUniform1f")) != 0L ? 1 : 0) & ((this.glProgramUniform2f = GLContext.getFunctionAddress("glProgramUniform2f")) != 0L ? 1 : 0) & ((this.glProgramUniform3f = GLContext.getFunctionAddress("glProgramUniform3f")) != 0L ? 1 : 0) & ((this.glProgramUniform4f = GLContext.getFunctionAddress("glProgramUniform4f")) != 0L ? 1 : 0) & ((this.glProgramUniform1d = GLContext.getFunctionAddress("glProgramUniform1d")) != 0L ? 1 : 0) & ((this.glProgramUniform2d = GLContext.getFunctionAddress("glProgramUniform2d")) != 0L ? 1 : 0) & ((this.glProgramUniform3d = GLContext.getFunctionAddress("glProgramUniform3d")) != 0L ? 1 : 0) & ((this.glProgramUniform4d = GLContext.getFunctionAddress("glProgramUniform4d")) != 0L ? 1 : 0) & ((this.glProgramUniform1iv = GLContext.getFunctionAddress("glProgramUniform1iv")) != 0L ? 1 : 0) & ((this.glProgramUniform2iv = GLContext.getFunctionAddress("glProgramUniform2iv")) != 0L ? 1 : 0) & ((this.glProgramUniform3iv = GLContext.getFunctionAddress("glProgramUniform3iv")) != 0L ? 1 : 0) & ((this.glProgramUniform4iv = GLContext.getFunctionAddress("glProgramUniform4iv")) != 0L ? 1 : 0) & ((this.glProgramUniform1fv = GLContext.getFunctionAddress("glProgramUniform1fv")) != 0L ? 1 : 0) & ((this.glProgramUniform2fv = GLContext.getFunctionAddress("glProgramUniform2fv")) != 0L ? 1 : 0) & ((this.glProgramUniform3fv = GLContext.getFunctionAddress("glProgramUniform3fv")) != 0L ? 1 : 0) & ((this.glProgramUniform4fv = GLContext.getFunctionAddress("glProgramUniform4fv")) != 0L ? 1 : 0) & ((this.glProgramUniform1dv = GLContext.getFunctionAddress("glProgramUniform1dv")) != 0L ? 1 : 0) & ((this.glProgramUniform2dv = GLContext.getFunctionAddress("glProgramUniform2dv")) != 0L ? 1 : 0) & ((this.glProgramUniform3dv = GLContext.getFunctionAddress("glProgramUniform3dv")) != 0L ? 1 : 0) & ((this.glProgramUniform4dv = GLContext.getFunctionAddress("glProgramUniform4dv")) != 0L ? 1 : 0) & ((this.glProgramUniform1ui = GLContext.getFunctionAddress("glProgramUniform1ui")) != 0L ? 1 : 0) & ((this.glProgramUniform2ui = GLContext.getFunctionAddress("glProgramUniform2ui")) != 0L ? 1 : 0) & ((this.glProgramUniform3ui = GLContext.getFunctionAddress("glProgramUniform3ui")) != 0L ? 1 : 0) & ((this.glProgramUniform4ui = GLContext.getFunctionAddress("glProgramUniform4ui")) != 0L ? 1 : 0) & ((this.glProgramUniform1uiv = GLContext.getFunctionAddress("glProgramUniform1uiv")) != 0L ? 1 : 0) & ((this.glProgramUniform2uiv = GLContext.getFunctionAddress("glProgramUniform2uiv")) != 0L ? 1 : 0) & ((this.glProgramUniform3uiv = GLContext.getFunctionAddress("glProgramUniform3uiv")) != 0L ? 1 : 0) & ((this.glProgramUniform4uiv = GLContext.getFunctionAddress("glProgramUniform4uiv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2fv = GLContext.getFunctionAddress("glProgramUniformMatrix2fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3fv = GLContext.getFunctionAddress("glProgramUniformMatrix3fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4fv = GLContext.getFunctionAddress("glProgramUniformMatrix4fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2dv = GLContext.getFunctionAddress("glProgramUniformMatrix2dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3dv = GLContext.getFunctionAddress("glProgramUniformMatrix3dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4dv = GLContext.getFunctionAddress("glProgramUniformMatrix4dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2x3fv = GLContext.getFunctionAddress("glProgramUniformMatrix2x3fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3x2fv = GLContext.getFunctionAddress("glProgramUniformMatrix3x2fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2x4fv = GLContext.getFunctionAddress("glProgramUniformMatrix2x4fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4x2fv = GLContext.getFunctionAddress("glProgramUniformMatrix4x2fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3x4fv = GLContext.getFunctionAddress("glProgramUniformMatrix3x4fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4x3fv = GLContext.getFunctionAddress("glProgramUniformMatrix4x3fv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2x3dv = GLContext.getFunctionAddress("glProgramUniformMatrix2x3dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3x2dv = GLContext.getFunctionAddress("glProgramUniformMatrix3x2dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix2x4dv = GLContext.getFunctionAddress("glProgramUniformMatrix2x4dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4x2dv = GLContext.getFunctionAddress("glProgramUniformMatrix4x2dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix3x4dv = GLContext.getFunctionAddress("glProgramUniformMatrix3x4dv")) != 0L ? 1 : 0) & ((this.glProgramUniformMatrix4x3dv = GLContext.getFunctionAddress("glProgramUniformMatrix4x3dv")) != 0L ? 1 : 0) & ((this.glValidateProgramPipeline = GLContext.getFunctionAddress("glValidateProgramPipeline")) != 0L ? 1 : 0) & ((this.glGetProgramPipelineInfoLog = GLContext.getFunctionAddress("glGetProgramPipelineInfoLog")) != 0L ? 1 : 0) & ((this.glVertexAttribL1d = GLContext.getFunctionAddress("glVertexAttribL1d")) != 0L ? 1 : 0) & ((this.glVertexAttribL2d = GLContext.getFunctionAddress("glVertexAttribL2d")) != 0L ? 1 : 0) & ((this.glVertexAttribL3d = GLContext.getFunctionAddress("glVertexAttribL3d")) != 0L ? 1 : 0) & ((this.glVertexAttribL4d = GLContext.getFunctionAddress("glVertexAttribL4d")) != 0L ? 1 : 0) & ((this.glVertexAttribL1dv = GLContext.getFunctionAddress("glVertexAttribL1dv")) != 0L ? 1 : 0) & ((this.glVertexAttribL2dv = GLContext.getFunctionAddress("glVertexAttribL2dv")) != 0L ? 1 : 0) & ((this.glVertexAttribL3dv = GLContext.getFunctionAddress("glVertexAttribL3dv")) != 0L ? 1 : 0) & ((this.glVertexAttribL4dv = GLContext.getFunctionAddress("glVertexAttribL4dv")) != 0L ? 1 : 0) & ((this.glVertexAttribLPointer = GLContext.getFunctionAddress("glVertexAttribLPointer")) != 0L ? 1 : 0) & ((this.glGetVertexAttribLdv = GLContext.getFunctionAddress("glGetVertexAttribLdv")) != 0L ? 1 : 0) & ((this.glViewportArrayv = GLContext.getFunctionAddress("glViewportArrayv")) != 0L ? 1 : 0) & ((this.glViewportIndexedf = GLContext.getFunctionAddress("glViewportIndexedf")) != 0L ? 1 : 0) & ((this.glViewportIndexedfv = GLContext.getFunctionAddress("glViewportIndexedfv")) != 0L ? 1 : 0) & ((this.glScissorArrayv = GLContext.getFunctionAddress("glScissorArrayv")) != 0L ? 1 : 0) & ((this.glScissorIndexed = GLContext.getFunctionAddress("glScissorIndexed")) != 0L ? 1 : 0) & ((this.glScissorIndexedv = GLContext.getFunctionAddress("glScissorIndexedv")) != 0L ? 1 : 0) & ((this.glDepthRangeArrayv = GLContext.getFunctionAddress("glDepthRangeArrayv")) != 0L ? 1 : 0) & ((this.glDepthRangeIndexed = GLContext.getFunctionAddress("glDepthRangeIndexed")) != 0L ? 1 : 0) & ((this.glGetFloati_v = GLContext.getFunctionAddress("glGetFloati_v")) != 0L ? 1 : 0) & ((this.glGetDoublei_v = GLContext.getFunctionAddress("glGetDoublei_v")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL42_initNativeFunctionAddresses()
/*      */   {
/* 4699 */     return 0x1 & (((this.glGetActiveAtomicCounterBufferiv = GLContext.getFunctionAddress("glGetActiveAtomicCounterBufferiv")) != 0L) || ((this.glTexStorage1D = GLContext.getFunctionAddress("glTexStorage1D")) != 0L) ? 1 : 0) & ((this.glTexStorage2D = GLContext.getFunctionAddress("glTexStorage2D")) != 0L ? 1 : 0) & ((this.glTexStorage3D = GLContext.getFunctionAddress("glTexStorage3D")) != 0L ? 1 : 0) & ((this.glDrawTransformFeedbackInstanced = GLContext.getFunctionAddress("glDrawTransformFeedbackInstanced")) != 0L ? 1 : 0) & ((this.glDrawTransformFeedbackStreamInstanced = GLContext.getFunctionAddress("glDrawTransformFeedbackStreamInstanced")) != 0L ? 1 : 0) & ((this.glDrawArraysInstancedBaseInstance = GLContext.getFunctionAddress("glDrawArraysInstancedBaseInstance")) != 0L ? 1 : 0) & ((this.glDrawElementsInstancedBaseInstance = GLContext.getFunctionAddress("glDrawElementsInstancedBaseInstance")) != 0L ? 1 : 0) & ((this.glDrawElementsInstancedBaseVertexBaseInstance = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertexBaseInstance")) != 0L ? 1 : 0) & ((this.glBindImageTexture = GLContext.getFunctionAddress("glBindImageTexture")) != 0L ? 1 : 0) & ((this.glMemoryBarrier = GLContext.getFunctionAddress("glMemoryBarrier")) != 0L ? 1 : 0) & ((this.glGetInternalformativ = GLContext.getFunctionAddress("glGetInternalformativ")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GL43_initNativeFunctionAddresses()
/*      */   {
/* 4715 */     return ((this.glClearBufferData = GLContext.getFunctionAddress("glClearBufferData")) != 0L ? 1 : 0) & ((this.glClearBufferSubData = GLContext.getFunctionAddress("glClearBufferSubData")) != 0L ? 1 : 0) & ((this.glDispatchCompute = GLContext.getFunctionAddress("glDispatchCompute")) != 0L ? 1 : 0) & ((this.glDispatchComputeIndirect = GLContext.getFunctionAddress("glDispatchComputeIndirect")) != 0L ? 1 : 0) & ((this.glCopyImageSubData = GLContext.getFunctionAddress("glCopyImageSubData")) != 0L ? 1 : 0) & ((this.glDebugMessageControl = GLContext.getFunctionAddress("glDebugMessageControl")) != 0L ? 1 : 0) & ((this.glDebugMessageInsert = GLContext.getFunctionAddress("glDebugMessageInsert")) != 0L ? 1 : 0) & ((this.glDebugMessageCallback = GLContext.getFunctionAddress("glDebugMessageCallback")) != 0L ? 1 : 0) & ((this.glGetDebugMessageLog = GLContext.getFunctionAddress("glGetDebugMessageLog")) != 0L ? 1 : 0) & ((this.glPushDebugGroup = GLContext.getFunctionAddress("glPushDebugGroup")) != 0L ? 1 : 0) & ((this.glPopDebugGroup = GLContext.getFunctionAddress("glPopDebugGroup")) != 0L ? 1 : 0) & ((this.glObjectLabel = GLContext.getFunctionAddress("glObjectLabel")) != 0L ? 1 : 0) & ((this.glGetObjectLabel = GLContext.getFunctionAddress("glGetObjectLabel")) != 0L ? 1 : 0) & ((this.glObjectPtrLabel = GLContext.getFunctionAddress("glObjectPtrLabel")) != 0L ? 1 : 0) & ((this.glGetObjectPtrLabel = GLContext.getFunctionAddress("glGetObjectPtrLabel")) != 0L ? 1 : 0) & ((this.glFramebufferParameteri = GLContext.getFunctionAddress("glFramebufferParameteri")) != 0L ? 1 : 0) & ((this.glGetFramebufferParameteriv = GLContext.getFunctionAddress("glGetFramebufferParameteriv")) != 0L ? 1 : 0) & ((this.glGetInternalformati64v = GLContext.getFunctionAddress("glGetInternalformati64v")) != 0L ? 1 : 0) & ((this.glInvalidateTexSubImage = GLContext.getFunctionAddress("glInvalidateTexSubImage")) != 0L ? 1 : 0) & ((this.glInvalidateTexImage = GLContext.getFunctionAddress("glInvalidateTexImage")) != 0L ? 1 : 0) & ((this.glInvalidateBufferSubData = GLContext.getFunctionAddress("glInvalidateBufferSubData")) != 0L ? 1 : 0) & ((this.glInvalidateBufferData = GLContext.getFunctionAddress("glInvalidateBufferData")) != 0L ? 1 : 0) & ((this.glInvalidateFramebuffer = GLContext.getFunctionAddress("glInvalidateFramebuffer")) != 0L ? 1 : 0) & ((this.glInvalidateSubFramebuffer = GLContext.getFunctionAddress("glInvalidateSubFramebuffer")) != 0L ? 1 : 0) & ((this.glMultiDrawArraysIndirect = GLContext.getFunctionAddress("glMultiDrawArraysIndirect")) != 0L ? 1 : 0) & ((this.glMultiDrawElementsIndirect = GLContext.getFunctionAddress("glMultiDrawElementsIndirect")) != 0L ? 1 : 0) & ((this.glGetProgramInterfaceiv = GLContext.getFunctionAddress("glGetProgramInterfaceiv")) != 0L ? 1 : 0) & ((this.glGetProgramResourceIndex = GLContext.getFunctionAddress("glGetProgramResourceIndex")) != 0L ? 1 : 0) & ((this.glGetProgramResourceName = GLContext.getFunctionAddress("glGetProgramResourceName")) != 0L ? 1 : 0) & ((this.glGetProgramResourceiv = GLContext.getFunctionAddress("glGetProgramResourceiv")) != 0L ? 1 : 0) & ((this.glGetProgramResourceLocation = GLContext.getFunctionAddress("glGetProgramResourceLocation")) != 0L ? 1 : 0) & ((this.glGetProgramResourceLocationIndex = GLContext.getFunctionAddress("glGetProgramResourceLocationIndex")) != 0L ? 1 : 0) & ((this.glShaderStorageBlockBinding = GLContext.getFunctionAddress("glShaderStorageBlockBinding")) != 0L ? 1 : 0) & ((this.glTexBufferRange = GLContext.getFunctionAddress("glTexBufferRange")) != 0L ? 1 : 0) & ((this.glTexStorage2DMultisample = GLContext.getFunctionAddress("glTexStorage2DMultisample")) != 0L ? 1 : 0) & ((this.glTexStorage3DMultisample = GLContext.getFunctionAddress("glTexStorage3DMultisample")) != 0L ? 1 : 0) & ((this.glTextureView = GLContext.getFunctionAddress("glTextureView")) != 0L ? 1 : 0) & ((this.glBindVertexBuffer = GLContext.getFunctionAddress("glBindVertexBuffer")) != 0L ? 1 : 0) & ((this.glVertexAttribFormat = GLContext.getFunctionAddress("glVertexAttribFormat")) != 0L ? 1 : 0) & ((this.glVertexAttribIFormat = GLContext.getFunctionAddress("glVertexAttribIFormat")) != 0L ? 1 : 0) & ((this.glVertexAttribLFormat = GLContext.getFunctionAddress("glVertexAttribLFormat")) != 0L ? 1 : 0) & ((this.glVertexAttribBinding = GLContext.getFunctionAddress("glVertexAttribBinding")) != 0L ? 1 : 0) & ((this.glVertexBindingDivisor = GLContext.getFunctionAddress("glVertexBindingDivisor")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean GREMEDY_frame_terminator_initNativeFunctionAddresses()
/*      */   {
/* 4762 */     return (this.glFrameTerminatorGREMEDY = GLContext.getFunctionAddress("glFrameTerminatorGREMEDY")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean GREMEDY_string_marker_initNativeFunctionAddresses()
/*      */   {
/* 4767 */     return (this.glStringMarkerGREMEDY = GLContext.getFunctionAddress("glStringMarkerGREMEDY")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean INTEL_map_texture_initNativeFunctionAddresses()
/*      */   {
/* 4772 */     return ((this.glMapTexture2DINTEL = GLContext.getFunctionAddress("glMapTexture2DINTEL")) != 0L ? 1 : 0) & ((this.glUnmapTexture2DINTEL = GLContext.getFunctionAddress("glUnmapTexture2DINTEL")) != 0L ? 1 : 0) & ((this.glSyncTextureINTEL = GLContext.getFunctionAddress("glSyncTextureINTEL")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean KHR_debug_initNativeFunctionAddresses()
/*      */   {
/* 4779 */     return ((this.glDebugMessageControl = GLContext.getFunctionAddress("glDebugMessageControl")) != 0L ? 1 : 0) & ((this.glDebugMessageInsert = GLContext.getFunctionAddress("glDebugMessageInsert")) != 0L ? 1 : 0) & ((this.glDebugMessageCallback = GLContext.getFunctionAddress("glDebugMessageCallback")) != 0L ? 1 : 0) & ((this.glGetDebugMessageLog = GLContext.getFunctionAddress("glGetDebugMessageLog")) != 0L ? 1 : 0) & ((this.glPushDebugGroup = GLContext.getFunctionAddress("glPushDebugGroup")) != 0L ? 1 : 0) & ((this.glPopDebugGroup = GLContext.getFunctionAddress("glPopDebugGroup")) != 0L ? 1 : 0) & ((this.glObjectLabel = GLContext.getFunctionAddress("glObjectLabel")) != 0L ? 1 : 0) & ((this.glGetObjectLabel = GLContext.getFunctionAddress("glGetObjectLabel")) != 0L ? 1 : 0) & ((this.glObjectPtrLabel = GLContext.getFunctionAddress("glObjectPtrLabel")) != 0L ? 1 : 0) & ((this.glGetObjectPtrLabel = GLContext.getFunctionAddress("glGetObjectPtrLabel")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_bindless_texture_initNativeFunctionAddresses()
/*      */   {
/* 4793 */     return ((this.glGetTextureHandleNV = GLContext.getFunctionAddress("glGetTextureHandleNV")) != 0L ? 1 : 0) & ((this.glGetTextureSamplerHandleNV = GLContext.getFunctionAddress("glGetTextureSamplerHandleNV")) != 0L ? 1 : 0) & ((this.glMakeTextureHandleResidentNV = GLContext.getFunctionAddress("glMakeTextureHandleResidentNV")) != 0L ? 1 : 0) & ((this.glMakeTextureHandleNonResidentNV = GLContext.getFunctionAddress("glMakeTextureHandleNonResidentNV")) != 0L ? 1 : 0) & ((this.glGetImageHandleNV = GLContext.getFunctionAddress("glGetImageHandleNV")) != 0L ? 1 : 0) & ((this.glMakeImageHandleResidentNV = GLContext.getFunctionAddress("glMakeImageHandleResidentNV")) != 0L ? 1 : 0) & ((this.glMakeImageHandleNonResidentNV = GLContext.getFunctionAddress("glMakeImageHandleNonResidentNV")) != 0L ? 1 : 0) & ((this.glUniformHandleui64NV = GLContext.getFunctionAddress("glUniformHandleui64NV")) != 0L ? 1 : 0) & ((this.glUniformHandleui64vNV = GLContext.getFunctionAddress("glUniformHandleui64vNV")) != 0L ? 1 : 0) & ((this.glProgramUniformHandleui64NV = GLContext.getFunctionAddress("glProgramUniformHandleui64NV")) != 0L ? 1 : 0) & ((this.glProgramUniformHandleui64vNV = GLContext.getFunctionAddress("glProgramUniformHandleui64vNV")) != 0L ? 1 : 0) & ((this.glIsTextureHandleResidentNV = GLContext.getFunctionAddress("glIsTextureHandleResidentNV")) != 0L ? 1 : 0) & ((this.glIsImageHandleResidentNV = GLContext.getFunctionAddress("glIsImageHandleResidentNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_conditional_render_initNativeFunctionAddresses()
/*      */   {
/* 4810 */     return ((this.glBeginConditionalRenderNV = GLContext.getFunctionAddress("glBeginConditionalRenderNV")) != 0L ? 1 : 0) & ((this.glEndConditionalRenderNV = GLContext.getFunctionAddress("glEndConditionalRenderNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_copy_image_initNativeFunctionAddresses()
/*      */   {
/* 4816 */     return (this.glCopyImageSubDataNV = GLContext.getFunctionAddress("glCopyImageSubDataNV")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean NV_depth_buffer_float_initNativeFunctionAddresses()
/*      */   {
/* 4821 */     return ((this.glDepthRangedNV = GLContext.getFunctionAddress("glDepthRangedNV")) != 0L ? 1 : 0) & ((this.glClearDepthdNV = GLContext.getFunctionAddress("glClearDepthdNV")) != 0L ? 1 : 0) & ((this.glDepthBoundsdNV = GLContext.getFunctionAddress("glDepthBoundsdNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_draw_texture_initNativeFunctionAddresses()
/*      */   {
/* 4828 */     return (this.glDrawTextureNV = GLContext.getFunctionAddress("glDrawTextureNV")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean NV_evaluators_initNativeFunctionAddresses()
/*      */   {
/* 4833 */     return ((this.glGetMapControlPointsNV = GLContext.getFunctionAddress("glGetMapControlPointsNV")) != 0L ? 1 : 0) & ((this.glMapControlPointsNV = GLContext.getFunctionAddress("glMapControlPointsNV")) != 0L ? 1 : 0) & ((this.glMapParameterfvNV = GLContext.getFunctionAddress("glMapParameterfvNV")) != 0L ? 1 : 0) & ((this.glMapParameterivNV = GLContext.getFunctionAddress("glMapParameterivNV")) != 0L ? 1 : 0) & ((this.glGetMapParameterfvNV = GLContext.getFunctionAddress("glGetMapParameterfvNV")) != 0L ? 1 : 0) & ((this.glGetMapParameterivNV = GLContext.getFunctionAddress("glGetMapParameterivNV")) != 0L ? 1 : 0) & ((this.glGetMapAttribParameterfvNV = GLContext.getFunctionAddress("glGetMapAttribParameterfvNV")) != 0L ? 1 : 0) & ((this.glGetMapAttribParameterivNV = GLContext.getFunctionAddress("glGetMapAttribParameterivNV")) != 0L ? 1 : 0) & ((this.glEvalMapsNV = GLContext.getFunctionAddress("glEvalMapsNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_explicit_multisample_initNativeFunctionAddresses()
/*      */   {
/* 4846 */     return ((this.glGetBooleanIndexedvEXT = GLContext.getFunctionAddress("glGetBooleanIndexedvEXT")) != 0L ? 1 : 0) & ((this.glGetIntegerIndexedvEXT = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT")) != 0L ? 1 : 0) & ((this.glGetMultisamplefvNV = GLContext.getFunctionAddress("glGetMultisamplefvNV")) != 0L ? 1 : 0) & ((this.glSampleMaskIndexedNV = GLContext.getFunctionAddress("glSampleMaskIndexedNV")) != 0L ? 1 : 0) & ((this.glTexRenderbufferNV = GLContext.getFunctionAddress("glTexRenderbufferNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_fence_initNativeFunctionAddresses()
/*      */   {
/* 4855 */     return ((this.glGenFencesNV = GLContext.getFunctionAddress("glGenFencesNV")) != 0L ? 1 : 0) & ((this.glDeleteFencesNV = GLContext.getFunctionAddress("glDeleteFencesNV")) != 0L ? 1 : 0) & ((this.glSetFenceNV = GLContext.getFunctionAddress("glSetFenceNV")) != 0L ? 1 : 0) & ((this.glTestFenceNV = GLContext.getFunctionAddress("glTestFenceNV")) != 0L ? 1 : 0) & ((this.glFinishFenceNV = GLContext.getFunctionAddress("glFinishFenceNV")) != 0L ? 1 : 0) & ((this.glIsFenceNV = GLContext.getFunctionAddress("glIsFenceNV")) != 0L ? 1 : 0) & ((this.glGetFenceivNV = GLContext.getFunctionAddress("glGetFenceivNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_fragment_program_initNativeFunctionAddresses()
/*      */   {
/* 4866 */     return ((this.glProgramNamedParameter4fNV = GLContext.getFunctionAddress("glProgramNamedParameter4fNV")) != 0L ? 1 : 0) & ((this.glProgramNamedParameter4dNV = GLContext.getFunctionAddress("glProgramNamedParameter4dNV")) != 0L ? 1 : 0) & ((this.glGetProgramNamedParameterfvNV = GLContext.getFunctionAddress("glGetProgramNamedParameterfvNV")) != 0L ? 1 : 0) & ((this.glGetProgramNamedParameterdvNV = GLContext.getFunctionAddress("glGetProgramNamedParameterdvNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_framebuffer_multisample_coverage_initNativeFunctionAddresses()
/*      */   {
/* 4874 */     return (this.glRenderbufferStorageMultisampleCoverageNV = GLContext.getFunctionAddress("glRenderbufferStorageMultisampleCoverageNV")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean NV_geometry_program4_initNativeFunctionAddresses()
/*      */   {
/* 4879 */     return ((this.glProgramVertexLimitNV = GLContext.getFunctionAddress("glProgramVertexLimitNV")) != 0L ? 1 : 0) & ((this.glFramebufferTextureEXT = GLContext.getFunctionAddress("glFramebufferTextureEXT")) != 0L ? 1 : 0) & ((this.glFramebufferTextureLayerEXT = GLContext.getFunctionAddress("glFramebufferTextureLayerEXT")) != 0L ? 1 : 0) & ((this.glFramebufferTextureFaceEXT = GLContext.getFunctionAddress("glFramebufferTextureFaceEXT")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_gpu_program4_initNativeFunctionAddresses()
/*      */   {
/* 4887 */     return ((this.glProgramLocalParameterI4iNV = GLContext.getFunctionAddress("glProgramLocalParameterI4iNV")) != 0L ? 1 : 0) & ((this.glProgramLocalParameterI4ivNV = GLContext.getFunctionAddress("glProgramLocalParameterI4ivNV")) != 0L ? 1 : 0) & ((this.glProgramLocalParametersI4ivNV = GLContext.getFunctionAddress("glProgramLocalParametersI4ivNV")) != 0L ? 1 : 0) & ((this.glProgramLocalParameterI4uiNV = GLContext.getFunctionAddress("glProgramLocalParameterI4uiNV")) != 0L ? 1 : 0) & ((this.glProgramLocalParameterI4uivNV = GLContext.getFunctionAddress("glProgramLocalParameterI4uivNV")) != 0L ? 1 : 0) & ((this.glProgramLocalParametersI4uivNV = GLContext.getFunctionAddress("glProgramLocalParametersI4uivNV")) != 0L ? 1 : 0) & ((this.glProgramEnvParameterI4iNV = GLContext.getFunctionAddress("glProgramEnvParameterI4iNV")) != 0L ? 1 : 0) & ((this.glProgramEnvParameterI4ivNV = GLContext.getFunctionAddress("glProgramEnvParameterI4ivNV")) != 0L ? 1 : 0) & ((this.glProgramEnvParametersI4ivNV = GLContext.getFunctionAddress("glProgramEnvParametersI4ivNV")) != 0L ? 1 : 0) & ((this.glProgramEnvParameterI4uiNV = GLContext.getFunctionAddress("glProgramEnvParameterI4uiNV")) != 0L ? 1 : 0) & ((this.glProgramEnvParameterI4uivNV = GLContext.getFunctionAddress("glProgramEnvParameterI4uivNV")) != 0L ? 1 : 0) & ((this.glProgramEnvParametersI4uivNV = GLContext.getFunctionAddress("glProgramEnvParametersI4uivNV")) != 0L ? 1 : 0) & ((this.glGetProgramLocalParameterIivNV = GLContext.getFunctionAddress("glGetProgramLocalParameterIivNV")) != 0L ? 1 : 0) & ((this.glGetProgramLocalParameterIuivNV = GLContext.getFunctionAddress("glGetProgramLocalParameterIuivNV")) != 0L ? 1 : 0) & ((this.glGetProgramEnvParameterIivNV = GLContext.getFunctionAddress("glGetProgramEnvParameterIivNV")) != 0L ? 1 : 0) & ((this.glGetProgramEnvParameterIuivNV = GLContext.getFunctionAddress("glGetProgramEnvParameterIuivNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_gpu_shader5_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 4907 */     return ((this.glUniform1i64NV = GLContext.getFunctionAddress("glUniform1i64NV")) != 0L ? 1 : 0) & ((this.glUniform2i64NV = GLContext.getFunctionAddress("glUniform2i64NV")) != 0L ? 1 : 0) & ((this.glUniform3i64NV = GLContext.getFunctionAddress("glUniform3i64NV")) != 0L ? 1 : 0) & ((this.glUniform4i64NV = GLContext.getFunctionAddress("glUniform4i64NV")) != 0L ? 1 : 0) & ((this.glUniform1i64vNV = GLContext.getFunctionAddress("glUniform1i64vNV")) != 0L ? 1 : 0) & ((this.glUniform2i64vNV = GLContext.getFunctionAddress("glUniform2i64vNV")) != 0L ? 1 : 0) & ((this.glUniform3i64vNV = GLContext.getFunctionAddress("glUniform3i64vNV")) != 0L ? 1 : 0) & ((this.glUniform4i64vNV = GLContext.getFunctionAddress("glUniform4i64vNV")) != 0L ? 1 : 0) & ((this.glUniform1ui64NV = GLContext.getFunctionAddress("glUniform1ui64NV")) != 0L ? 1 : 0) & ((this.glUniform2ui64NV = GLContext.getFunctionAddress("glUniform2ui64NV")) != 0L ? 1 : 0) & ((this.glUniform3ui64NV = GLContext.getFunctionAddress("glUniform3ui64NV")) != 0L ? 1 : 0) & ((this.glUniform4ui64NV = GLContext.getFunctionAddress("glUniform4ui64NV")) != 0L ? 1 : 0) & ((this.glUniform1ui64vNV = GLContext.getFunctionAddress("glUniform1ui64vNV")) != 0L ? 1 : 0) & ((this.glUniform2ui64vNV = GLContext.getFunctionAddress("glUniform2ui64vNV")) != 0L ? 1 : 0) & ((this.glUniform3ui64vNV = GLContext.getFunctionAddress("glUniform3ui64vNV")) != 0L ? 1 : 0) & ((this.glUniform4ui64vNV = GLContext.getFunctionAddress("glUniform4ui64vNV")) != 0L ? 1 : 0) & ((this.glGetUniformi64vNV = GLContext.getFunctionAddress("glGetUniformi64vNV")) != 0L ? 1 : 0) & ((this.glGetUniformui64vNV = GLContext.getFunctionAddress("glGetUniformui64vNV")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform1i64NV = GLContext.getFunctionAddress("glProgramUniform1i64NV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform2i64NV = GLContext.getFunctionAddress("glProgramUniform2i64NV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform3i64NV = GLContext.getFunctionAddress("glProgramUniform3i64NV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform4i64NV = GLContext.getFunctionAddress("glProgramUniform4i64NV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform1i64vNV = GLContext.getFunctionAddress("glProgramUniform1i64vNV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform2i64vNV = GLContext.getFunctionAddress("glProgramUniform2i64vNV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform3i64vNV = GLContext.getFunctionAddress("glProgramUniform3i64vNV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform4i64vNV = GLContext.getFunctionAddress("glProgramUniform4i64vNV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform1ui64NV = GLContext.getFunctionAddress("glProgramUniform1ui64NV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform2ui64NV = GLContext.getFunctionAddress("glProgramUniform2ui64NV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform3ui64NV = GLContext.getFunctionAddress("glProgramUniform3ui64NV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform4ui64NV = GLContext.getFunctionAddress("glProgramUniform4ui64NV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform1ui64vNV = GLContext.getFunctionAddress("glProgramUniform1ui64vNV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform2ui64vNV = GLContext.getFunctionAddress("glProgramUniform2ui64vNV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform3ui64vNV = GLContext.getFunctionAddress("glProgramUniform3ui64vNV")) != 0L) ? 1 : 0) & ((!supported_extensions.contains("GL_EXT_direct_state_access")) || ((this.glProgramUniform4ui64vNV = GLContext.getFunctionAddress("glProgramUniform4ui64vNV")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_half_float_initNativeFunctionAddresses()
/*      */   {
/* 4945 */     if (((this.glVertexWeighthNV = GLContext.getFunctionAddress("glVertexWeighthNV")) != 0L) || (((this.glVertexAttrib1hNV = GLContext.getFunctionAddress("glVertexAttrib1hNV")) != 0L) || (((this.glVertexAttrib2hNV = GLContext.getFunctionAddress("glVertexAttrib2hNV")) != 0L) || (((this.glVertexAttrib3hNV = GLContext.getFunctionAddress("glVertexAttrib3hNV")) != 0L) || (((this.glVertexAttrib4hNV = GLContext.getFunctionAddress("glVertexAttrib4hNV")) != 0L) || (((this.glVertexAttribs1hvNV = GLContext.getFunctionAddress("glVertexAttribs1hvNV")) != 0L) || (((this.glVertexAttribs2hvNV = GLContext.getFunctionAddress("glVertexAttribs2hvNV")) != 0L) || (((this.glVertexAttribs3hvNV = GLContext.getFunctionAddress("glVertexAttribs3hvNV")) != 0L) || ((this.glVertexAttribs4hvNV = GLContext.getFunctionAddress("glVertexAttribs4hvNV")) == 0L)))))))));
/* 4945 */     return ((this.glVertex2hNV = GLContext.getFunctionAddress("glVertex2hNV")) != 0L ? 1 : 0) & ((this.glVertex3hNV = GLContext.getFunctionAddress("glVertex3hNV")) != 0L ? 1 : 0) & ((this.glVertex4hNV = GLContext.getFunctionAddress("glVertex4hNV")) != 0L ? 1 : 0) & ((this.glNormal3hNV = GLContext.getFunctionAddress("glNormal3hNV")) != 0L ? 1 : 0) & ((this.glColor3hNV = GLContext.getFunctionAddress("glColor3hNV")) != 0L ? 1 : 0) & ((this.glColor4hNV = GLContext.getFunctionAddress("glColor4hNV")) != 0L ? 1 : 0) & ((this.glTexCoord1hNV = GLContext.getFunctionAddress("glTexCoord1hNV")) != 0L ? 1 : 0) & ((this.glTexCoord2hNV = GLContext.getFunctionAddress("glTexCoord2hNV")) != 0L ? 1 : 0) & ((this.glTexCoord3hNV = GLContext.getFunctionAddress("glTexCoord3hNV")) != 0L ? 1 : 0) & ((this.glTexCoord4hNV = GLContext.getFunctionAddress("glTexCoord4hNV")) != 0L ? 1 : 0) & ((this.glMultiTexCoord1hNV = GLContext.getFunctionAddress("glMultiTexCoord1hNV")) != 0L ? 1 : 0) & ((this.glMultiTexCoord2hNV = GLContext.getFunctionAddress("glMultiTexCoord2hNV")) != 0L ? 1 : 0) & ((this.glMultiTexCoord3hNV = GLContext.getFunctionAddress("glMultiTexCoord3hNV")) != 0L ? 1 : 0) & ((this.glMultiTexCoord4hNV = GLContext.getFunctionAddress("glMultiTexCoord4hNV")) != 0L ? 1 : 0) & ((this.glFogCoordhNV = GLContext.getFunctionAddress("glFogCoordhNV")) != 0L ? 1 : 0) & ((this.glSecondaryColor3hNV = GLContext.getFunctionAddress("glSecondaryColor3hNV")) != 0L ? 1 : 0) & 0x1 & 0x1 & 0x1 & 0x1 & 0x1 & 0x1 & 0x1 & 0x1 & 0x1;
/*      */   }
/*      */ 
/*      */   private boolean NV_occlusion_query_initNativeFunctionAddresses()
/*      */   {
/* 4974 */     return ((this.glGenOcclusionQueriesNV = GLContext.getFunctionAddress("glGenOcclusionQueriesNV")) != 0L ? 1 : 0) & ((this.glDeleteOcclusionQueriesNV = GLContext.getFunctionAddress("glDeleteOcclusionQueriesNV")) != 0L ? 1 : 0) & ((this.glIsOcclusionQueryNV = GLContext.getFunctionAddress("glIsOcclusionQueryNV")) != 0L ? 1 : 0) & ((this.glBeginOcclusionQueryNV = GLContext.getFunctionAddress("glBeginOcclusionQueryNV")) != 0L ? 1 : 0) & ((this.glEndOcclusionQueryNV = GLContext.getFunctionAddress("glEndOcclusionQueryNV")) != 0L ? 1 : 0) & ((this.glGetOcclusionQueryuivNV = GLContext.getFunctionAddress("glGetOcclusionQueryuivNV")) != 0L ? 1 : 0) & ((this.glGetOcclusionQueryivNV = GLContext.getFunctionAddress("glGetOcclusionQueryivNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_parameter_buffer_object_initNativeFunctionAddresses()
/*      */   {
/* 4985 */     return ((this.glProgramBufferParametersfvNV = GLContext.getFunctionAddress("glProgramBufferParametersfvNV")) != 0L ? 1 : 0) & ((this.glProgramBufferParametersIivNV = GLContext.getFunctionAddress("glProgramBufferParametersIivNV")) != 0L ? 1 : 0) & ((this.glProgramBufferParametersIuivNV = GLContext.getFunctionAddress("glProgramBufferParametersIuivNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_path_rendering_initNativeFunctionAddresses()
/*      */   {
/* 4992 */     return ((this.glPathCommandsNV = GLContext.getFunctionAddress("glPathCommandsNV")) != 0L ? 1 : 0) & ((this.glPathCoordsNV = GLContext.getFunctionAddress("glPathCoordsNV")) != 0L ? 1 : 0) & ((this.glPathSubCommandsNV = GLContext.getFunctionAddress("glPathSubCommandsNV")) != 0L ? 1 : 0) & ((this.glPathSubCoordsNV = GLContext.getFunctionAddress("glPathSubCoordsNV")) != 0L ? 1 : 0) & ((this.glPathStringNV = GLContext.getFunctionAddress("glPathStringNV")) != 0L ? 1 : 0) & ((this.glPathGlyphsNV = GLContext.getFunctionAddress("glPathGlyphsNV")) != 0L ? 1 : 0) & ((this.glPathGlyphRangeNV = GLContext.getFunctionAddress("glPathGlyphRangeNV")) != 0L ? 1 : 0) & ((this.glWeightPathsNV = GLContext.getFunctionAddress("glWeightPathsNV")) != 0L ? 1 : 0) & ((this.glCopyPathNV = GLContext.getFunctionAddress("glCopyPathNV")) != 0L ? 1 : 0) & ((this.glInterpolatePathsNV = GLContext.getFunctionAddress("glInterpolatePathsNV")) != 0L ? 1 : 0) & ((this.glTransformPathNV = GLContext.getFunctionAddress("glTransformPathNV")) != 0L ? 1 : 0) & ((this.glPathParameterivNV = GLContext.getFunctionAddress("glPathParameterivNV")) != 0L ? 1 : 0) & ((this.glPathParameteriNV = GLContext.getFunctionAddress("glPathParameteriNV")) != 0L ? 1 : 0) & ((this.glPathParameterfvNV = GLContext.getFunctionAddress("glPathParameterfvNV")) != 0L ? 1 : 0) & ((this.glPathParameterfNV = GLContext.getFunctionAddress("glPathParameterfNV")) != 0L ? 1 : 0) & ((this.glPathDashArrayNV = GLContext.getFunctionAddress("glPathDashArrayNV")) != 0L ? 1 : 0) & ((this.glGenPathsNV = GLContext.getFunctionAddress("glGenPathsNV")) != 0L ? 1 : 0) & ((this.glDeletePathsNV = GLContext.getFunctionAddress("glDeletePathsNV")) != 0L ? 1 : 0) & ((this.glIsPathNV = GLContext.getFunctionAddress("glIsPathNV")) != 0L ? 1 : 0) & ((this.glPathStencilFuncNV = GLContext.getFunctionAddress("glPathStencilFuncNV")) != 0L ? 1 : 0) & ((this.glPathStencilDepthOffsetNV = GLContext.getFunctionAddress("glPathStencilDepthOffsetNV")) != 0L ? 1 : 0) & ((this.glStencilFillPathNV = GLContext.getFunctionAddress("glStencilFillPathNV")) != 0L ? 1 : 0) & ((this.glStencilStrokePathNV = GLContext.getFunctionAddress("glStencilStrokePathNV")) != 0L ? 1 : 0) & ((this.glStencilFillPathInstancedNV = GLContext.getFunctionAddress("glStencilFillPathInstancedNV")) != 0L ? 1 : 0) & ((this.glStencilStrokePathInstancedNV = GLContext.getFunctionAddress("glStencilStrokePathInstancedNV")) != 0L ? 1 : 0) & ((this.glPathCoverDepthFuncNV = GLContext.getFunctionAddress("glPathCoverDepthFuncNV")) != 0L ? 1 : 0) & ((this.glPathColorGenNV = GLContext.getFunctionAddress("glPathColorGenNV")) != 0L ? 1 : 0) & ((this.glPathTexGenNV = GLContext.getFunctionAddress("glPathTexGenNV")) != 0L ? 1 : 0) & ((this.glPathFogGenNV = GLContext.getFunctionAddress("glPathFogGenNV")) != 0L ? 1 : 0) & ((this.glCoverFillPathNV = GLContext.getFunctionAddress("glCoverFillPathNV")) != 0L ? 1 : 0) & ((this.glCoverStrokePathNV = GLContext.getFunctionAddress("glCoverStrokePathNV")) != 0L ? 1 : 0) & ((this.glCoverFillPathInstancedNV = GLContext.getFunctionAddress("glCoverFillPathInstancedNV")) != 0L ? 1 : 0) & ((this.glCoverStrokePathInstancedNV = GLContext.getFunctionAddress("glCoverStrokePathInstancedNV")) != 0L ? 1 : 0) & ((this.glGetPathParameterivNV = GLContext.getFunctionAddress("glGetPathParameterivNV")) != 0L ? 1 : 0) & ((this.glGetPathParameterfvNV = GLContext.getFunctionAddress("glGetPathParameterfvNV")) != 0L ? 1 : 0) & ((this.glGetPathCommandsNV = GLContext.getFunctionAddress("glGetPathCommandsNV")) != 0L ? 1 : 0) & ((this.glGetPathCoordsNV = GLContext.getFunctionAddress("glGetPathCoordsNV")) != 0L ? 1 : 0) & ((this.glGetPathDashArrayNV = GLContext.getFunctionAddress("glGetPathDashArrayNV")) != 0L ? 1 : 0) & ((this.glGetPathMetricsNV = GLContext.getFunctionAddress("glGetPathMetricsNV")) != 0L ? 1 : 0) & ((this.glGetPathMetricRangeNV = GLContext.getFunctionAddress("glGetPathMetricRangeNV")) != 0L ? 1 : 0) & ((this.glGetPathSpacingNV = GLContext.getFunctionAddress("glGetPathSpacingNV")) != 0L ? 1 : 0) & ((this.glGetPathColorGenivNV = GLContext.getFunctionAddress("glGetPathColorGenivNV")) != 0L ? 1 : 0) & ((this.glGetPathColorGenfvNV = GLContext.getFunctionAddress("glGetPathColorGenfvNV")) != 0L ? 1 : 0) & ((this.glGetPathTexGenivNV = GLContext.getFunctionAddress("glGetPathTexGenivNV")) != 0L ? 1 : 0) & ((this.glGetPathTexGenfvNV = GLContext.getFunctionAddress("glGetPathTexGenfvNV")) != 0L ? 1 : 0) & ((this.glIsPointInFillPathNV = GLContext.getFunctionAddress("glIsPointInFillPathNV")) != 0L ? 1 : 0) & ((this.glIsPointInStrokePathNV = GLContext.getFunctionAddress("glIsPointInStrokePathNV")) != 0L ? 1 : 0) & ((this.glGetPathLengthNV = GLContext.getFunctionAddress("glGetPathLengthNV")) != 0L ? 1 : 0) & ((this.glPointAlongPathNV = GLContext.getFunctionAddress("glPointAlongPathNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_pixel_data_range_initNativeFunctionAddresses()
/*      */   {
/* 5045 */     return ((this.glPixelDataRangeNV = GLContext.getFunctionAddress("glPixelDataRangeNV")) != 0L ? 1 : 0) & ((this.glFlushPixelDataRangeNV = GLContext.getFunctionAddress("glFlushPixelDataRangeNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_point_sprite_initNativeFunctionAddresses()
/*      */   {
/* 5051 */     return ((this.glPointParameteriNV = GLContext.getFunctionAddress("glPointParameteriNV")) != 0L ? 1 : 0) & ((this.glPointParameterivNV = GLContext.getFunctionAddress("glPointParameterivNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_present_video_initNativeFunctionAddresses()
/*      */   {
/* 5057 */     return ((this.glPresentFrameKeyedNV = GLContext.getFunctionAddress("glPresentFrameKeyedNV")) != 0L ? 1 : 0) & ((this.glPresentFrameDualFillNV = GLContext.getFunctionAddress("glPresentFrameDualFillNV")) != 0L ? 1 : 0) & ((this.glGetVideoivNV = GLContext.getFunctionAddress("glGetVideoivNV")) != 0L ? 1 : 0) & ((this.glGetVideouivNV = GLContext.getFunctionAddress("glGetVideouivNV")) != 0L ? 1 : 0) & ((this.glGetVideoi64vNV = GLContext.getFunctionAddress("glGetVideoi64vNV")) != 0L ? 1 : 0) & ((this.glGetVideoui64vNV = GLContext.getFunctionAddress("glGetVideoui64vNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_primitive_restart_initNativeFunctionAddresses()
/*      */   {
/* 5067 */     return ((this.glPrimitiveRestartNV = GLContext.getFunctionAddress("glPrimitiveRestartNV")) != 0L ? 1 : 0) & ((this.glPrimitiveRestartIndexNV = GLContext.getFunctionAddress("glPrimitiveRestartIndexNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_program_initNativeFunctionAddresses()
/*      */   {
/* 5073 */     return ((this.glLoadProgramNV = GLContext.getFunctionAddress("glLoadProgramNV")) != 0L ? 1 : 0) & ((this.glBindProgramNV = GLContext.getFunctionAddress("glBindProgramNV")) != 0L ? 1 : 0) & ((this.glDeleteProgramsNV = GLContext.getFunctionAddress("glDeleteProgramsNV")) != 0L ? 1 : 0) & ((this.glGenProgramsNV = GLContext.getFunctionAddress("glGenProgramsNV")) != 0L ? 1 : 0) & ((this.glGetProgramivNV = GLContext.getFunctionAddress("glGetProgramivNV")) != 0L ? 1 : 0) & ((this.glGetProgramStringNV = GLContext.getFunctionAddress("glGetProgramStringNV")) != 0L ? 1 : 0) & ((this.glIsProgramNV = GLContext.getFunctionAddress("glIsProgramNV")) != 0L ? 1 : 0) & ((this.glAreProgramsResidentNV = GLContext.getFunctionAddress("glAreProgramsResidentNV")) != 0L ? 1 : 0) & ((this.glRequestResidentProgramsNV = GLContext.getFunctionAddress("glRequestResidentProgramsNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_register_combiners_initNativeFunctionAddresses()
/*      */   {
/* 5086 */     return ((this.glCombinerParameterfNV = GLContext.getFunctionAddress("glCombinerParameterfNV")) != 0L ? 1 : 0) & ((this.glCombinerParameterfvNV = GLContext.getFunctionAddress("glCombinerParameterfvNV")) != 0L ? 1 : 0) & ((this.glCombinerParameteriNV = GLContext.getFunctionAddress("glCombinerParameteriNV")) != 0L ? 1 : 0) & ((this.glCombinerParameterivNV = GLContext.getFunctionAddress("glCombinerParameterivNV")) != 0L ? 1 : 0) & ((this.glCombinerInputNV = GLContext.getFunctionAddress("glCombinerInputNV")) != 0L ? 1 : 0) & ((this.glCombinerOutputNV = GLContext.getFunctionAddress("glCombinerOutputNV")) != 0L ? 1 : 0) & ((this.glFinalCombinerInputNV = GLContext.getFunctionAddress("glFinalCombinerInputNV")) != 0L ? 1 : 0) & ((this.glGetCombinerInputParameterfvNV = GLContext.getFunctionAddress("glGetCombinerInputParameterfvNV")) != 0L ? 1 : 0) & ((this.glGetCombinerInputParameterivNV = GLContext.getFunctionAddress("glGetCombinerInputParameterivNV")) != 0L ? 1 : 0) & ((this.glGetCombinerOutputParameterfvNV = GLContext.getFunctionAddress("glGetCombinerOutputParameterfvNV")) != 0L ? 1 : 0) & ((this.glGetCombinerOutputParameterivNV = GLContext.getFunctionAddress("glGetCombinerOutputParameterivNV")) != 0L ? 1 : 0) & ((this.glGetFinalCombinerInputParameterfvNV = GLContext.getFunctionAddress("glGetFinalCombinerInputParameterfvNV")) != 0L ? 1 : 0) & ((this.glGetFinalCombinerInputParameterivNV = GLContext.getFunctionAddress("glGetFinalCombinerInputParameterivNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_register_combiners2_initNativeFunctionAddresses()
/*      */   {
/* 5103 */     return ((this.glCombinerStageParameterfvNV = GLContext.getFunctionAddress("glCombinerStageParameterfvNV")) != 0L ? 1 : 0) & ((this.glGetCombinerStageParameterfvNV = GLContext.getFunctionAddress("glGetCombinerStageParameterfvNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_shader_buffer_load_initNativeFunctionAddresses()
/*      */   {
/* 5109 */     return ((this.glMakeBufferResidentNV = GLContext.getFunctionAddress("glMakeBufferResidentNV")) != 0L ? 1 : 0) & ((this.glMakeBufferNonResidentNV = GLContext.getFunctionAddress("glMakeBufferNonResidentNV")) != 0L ? 1 : 0) & ((this.glIsBufferResidentNV = GLContext.getFunctionAddress("glIsBufferResidentNV")) != 0L ? 1 : 0) & ((this.glMakeNamedBufferResidentNV = GLContext.getFunctionAddress("glMakeNamedBufferResidentNV")) != 0L ? 1 : 0) & ((this.glMakeNamedBufferNonResidentNV = GLContext.getFunctionAddress("glMakeNamedBufferNonResidentNV")) != 0L ? 1 : 0) & ((this.glIsNamedBufferResidentNV = GLContext.getFunctionAddress("glIsNamedBufferResidentNV")) != 0L ? 1 : 0) & ((this.glGetBufferParameterui64vNV = GLContext.getFunctionAddress("glGetBufferParameterui64vNV")) != 0L ? 1 : 0) & ((this.glGetNamedBufferParameterui64vNV = GLContext.getFunctionAddress("glGetNamedBufferParameterui64vNV")) != 0L ? 1 : 0) & ((this.glGetIntegerui64vNV = GLContext.getFunctionAddress("glGetIntegerui64vNV")) != 0L ? 1 : 0) & ((this.glUniformui64NV = GLContext.getFunctionAddress("glUniformui64NV")) != 0L ? 1 : 0) & ((this.glUniformui64vNV = GLContext.getFunctionAddress("glUniformui64vNV")) != 0L ? 1 : 0) & ((this.glGetUniformui64vNV = GLContext.getFunctionAddress("glGetUniformui64vNV")) != 0L ? 1 : 0) & ((this.glProgramUniformui64NV = GLContext.getFunctionAddress("glProgramUniformui64NV")) != 0L ? 1 : 0) & ((this.glProgramUniformui64vNV = GLContext.getFunctionAddress("glProgramUniformui64vNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_texture_barrier_initNativeFunctionAddresses()
/*      */   {
/* 5127 */     return (this.glTextureBarrierNV = GLContext.getFunctionAddress("glTextureBarrierNV")) != 0L;
/*      */   }
/*      */ 
/*      */   private boolean NV_texture_multisample_initNativeFunctionAddresses()
/*      */   {
/* 5132 */     return ((this.glTexImage2DMultisampleCoverageNV = GLContext.getFunctionAddress("glTexImage2DMultisampleCoverageNV")) != 0L ? 1 : 0) & ((this.glTexImage3DMultisampleCoverageNV = GLContext.getFunctionAddress("glTexImage3DMultisampleCoverageNV")) != 0L ? 1 : 0) & ((this.glTextureImage2DMultisampleNV = GLContext.getFunctionAddress("glTextureImage2DMultisampleNV")) != 0L ? 1 : 0) & ((this.glTextureImage3DMultisampleNV = GLContext.getFunctionAddress("glTextureImage3DMultisampleNV")) != 0L ? 1 : 0) & ((this.glTextureImage2DMultisampleCoverageNV = GLContext.getFunctionAddress("glTextureImage2DMultisampleCoverageNV")) != 0L ? 1 : 0) & ((this.glTextureImage3DMultisampleCoverageNV = GLContext.getFunctionAddress("glTextureImage3DMultisampleCoverageNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_transform_feedback_initNativeFunctionAddresses()
/*      */   {
/* 5142 */     return ((this.glBindBufferRangeNV = GLContext.getFunctionAddress("glBindBufferRangeNV")) != 0L ? 1 : 0) & ((this.glBindBufferOffsetNV = GLContext.getFunctionAddress("glBindBufferOffsetNV")) != 0L ? 1 : 0) & ((this.glBindBufferBaseNV = GLContext.getFunctionAddress("glBindBufferBaseNV")) != 0L ? 1 : 0) & ((this.glTransformFeedbackAttribsNV = GLContext.getFunctionAddress("glTransformFeedbackAttribsNV")) != 0L ? 1 : 0) & ((this.glTransformFeedbackVaryingsNV = GLContext.getFunctionAddress("glTransformFeedbackVaryingsNV")) != 0L ? 1 : 0) & ((this.glBeginTransformFeedbackNV = GLContext.getFunctionAddress("glBeginTransformFeedbackNV")) != 0L ? 1 : 0) & ((this.glEndTransformFeedbackNV = GLContext.getFunctionAddress("glEndTransformFeedbackNV")) != 0L ? 1 : 0) & ((this.glGetVaryingLocationNV = GLContext.getFunctionAddress("glGetVaryingLocationNV")) != 0L ? 1 : 0) & ((this.glGetActiveVaryingNV = GLContext.getFunctionAddress("glGetActiveVaryingNV")) != 0L ? 1 : 0) & ((this.glActiveVaryingNV = GLContext.getFunctionAddress("glActiveVaryingNV")) != 0L ? 1 : 0) & ((this.glGetTransformFeedbackVaryingNV = GLContext.getFunctionAddress("glGetTransformFeedbackVaryingNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_transform_feedback2_initNativeFunctionAddresses()
/*      */   {
/* 5157 */     return ((this.glBindTransformFeedbackNV = GLContext.getFunctionAddress("glBindTransformFeedbackNV")) != 0L ? 1 : 0) & ((this.glDeleteTransformFeedbacksNV = GLContext.getFunctionAddress("glDeleteTransformFeedbacksNV")) != 0L ? 1 : 0) & ((this.glGenTransformFeedbacksNV = GLContext.getFunctionAddress("glGenTransformFeedbacksNV")) != 0L ? 1 : 0) & ((this.glIsTransformFeedbackNV = GLContext.getFunctionAddress("glIsTransformFeedbackNV")) != 0L ? 1 : 0) & ((this.glPauseTransformFeedbackNV = GLContext.getFunctionAddress("glPauseTransformFeedbackNV")) != 0L ? 1 : 0) & ((this.glResumeTransformFeedbackNV = GLContext.getFunctionAddress("glResumeTransformFeedbackNV")) != 0L ? 1 : 0) & ((this.glDrawTransformFeedbackNV = GLContext.getFunctionAddress("glDrawTransformFeedbackNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_vertex_array_range_initNativeFunctionAddresses()
/*      */   {
/* 5168 */     return ((this.glVertexArrayRangeNV = GLContext.getFunctionAddress("glVertexArrayRangeNV")) != 0L ? 1 : 0) & ((this.glFlushVertexArrayRangeNV = GLContext.getFunctionAddress("glFlushVertexArrayRangeNV")) != 0L ? 1 : 0) & ((this.glAllocateMemoryNV = GLContext.getPlatformSpecificFunctionAddress("gl", new String[] { "Windows", "Linux" }, new String[] { "wgl", "glX" }, "glAllocateMemoryNV")) != 0L ? 1 : 0) & ((this.glFreeMemoryNV = GLContext.getPlatformSpecificFunctionAddress("gl", new String[] { "Windows", "Linux" }, new String[] { "wgl", "glX" }, "glFreeMemoryNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_vertex_attrib_integer_64bit_initNativeFunctionAddresses(Set<String> supported_extensions)
/*      */   {
/* 5176 */     return ((this.glVertexAttribL1i64NV = GLContext.getFunctionAddress("glVertexAttribL1i64NV")) != 0L ? 1 : 0) & ((this.glVertexAttribL2i64NV = GLContext.getFunctionAddress("glVertexAttribL2i64NV")) != 0L ? 1 : 0) & ((this.glVertexAttribL3i64NV = GLContext.getFunctionAddress("glVertexAttribL3i64NV")) != 0L ? 1 : 0) & ((this.glVertexAttribL4i64NV = GLContext.getFunctionAddress("glVertexAttribL4i64NV")) != 0L ? 1 : 0) & ((this.glVertexAttribL1i64vNV = GLContext.getFunctionAddress("glVertexAttribL1i64vNV")) != 0L ? 1 : 0) & ((this.glVertexAttribL2i64vNV = GLContext.getFunctionAddress("glVertexAttribL2i64vNV")) != 0L ? 1 : 0) & ((this.glVertexAttribL3i64vNV = GLContext.getFunctionAddress("glVertexAttribL3i64vNV")) != 0L ? 1 : 0) & ((this.glVertexAttribL4i64vNV = GLContext.getFunctionAddress("glVertexAttribL4i64vNV")) != 0L ? 1 : 0) & ((this.glVertexAttribL1ui64NV = GLContext.getFunctionAddress("glVertexAttribL1ui64NV")) != 0L ? 1 : 0) & ((this.glVertexAttribL2ui64NV = GLContext.getFunctionAddress("glVertexAttribL2ui64NV")) != 0L ? 1 : 0) & ((this.glVertexAttribL3ui64NV = GLContext.getFunctionAddress("glVertexAttribL3ui64NV")) != 0L ? 1 : 0) & ((this.glVertexAttribL4ui64NV = GLContext.getFunctionAddress("glVertexAttribL4ui64NV")) != 0L ? 1 : 0) & ((this.glVertexAttribL1ui64vNV = GLContext.getFunctionAddress("glVertexAttribL1ui64vNV")) != 0L ? 1 : 0) & ((this.glVertexAttribL2ui64vNV = GLContext.getFunctionAddress("glVertexAttribL2ui64vNV")) != 0L ? 1 : 0) & ((this.glVertexAttribL3ui64vNV = GLContext.getFunctionAddress("glVertexAttribL3ui64vNV")) != 0L ? 1 : 0) & ((this.glVertexAttribL4ui64vNV = GLContext.getFunctionAddress("glVertexAttribL4ui64vNV")) != 0L ? 1 : 0) & ((this.glGetVertexAttribLi64vNV = GLContext.getFunctionAddress("glGetVertexAttribLi64vNV")) != 0L ? 1 : 0) & ((this.glGetVertexAttribLui64vNV = GLContext.getFunctionAddress("glGetVertexAttribLui64vNV")) != 0L ? 1 : 0) & ((!supported_extensions.contains("GL_NV_vertex_buffer_unified_memory")) || ((this.glVertexAttribLFormatNV = GLContext.getFunctionAddress("glVertexAttribLFormatNV")) != 0L) ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_vertex_buffer_unified_memory_initNativeFunctionAddresses()
/*      */   {
/* 5199 */     return ((this.glBufferAddressRangeNV = GLContext.getFunctionAddress("glBufferAddressRangeNV")) != 0L ? 1 : 0) & ((this.glVertexFormatNV = GLContext.getFunctionAddress("glVertexFormatNV")) != 0L ? 1 : 0) & ((this.glNormalFormatNV = GLContext.getFunctionAddress("glNormalFormatNV")) != 0L ? 1 : 0) & ((this.glColorFormatNV = GLContext.getFunctionAddress("glColorFormatNV")) != 0L ? 1 : 0) & ((this.glIndexFormatNV = GLContext.getFunctionAddress("glIndexFormatNV")) != 0L ? 1 : 0) & ((this.glTexCoordFormatNV = GLContext.getFunctionAddress("glTexCoordFormatNV")) != 0L ? 1 : 0) & ((this.glEdgeFlagFormatNV = GLContext.getFunctionAddress("glEdgeFlagFormatNV")) != 0L ? 1 : 0) & ((this.glSecondaryColorFormatNV = GLContext.getFunctionAddress("glSecondaryColorFormatNV")) != 0L ? 1 : 0) & ((this.glFogCoordFormatNV = GLContext.getFunctionAddress("glFogCoordFormatNV")) != 0L ? 1 : 0) & ((this.glVertexAttribFormatNV = GLContext.getFunctionAddress("glVertexAttribFormatNV")) != 0L ? 1 : 0) & ((this.glVertexAttribIFormatNV = GLContext.getFunctionAddress("glVertexAttribIFormatNV")) != 0L ? 1 : 0) & ((this.glGetIntegerui64i_vNV = GLContext.getFunctionAddress("glGetIntegerui64i_vNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_vertex_program_initNativeFunctionAddresses()
/*      */   {
/* 5215 */     return ((this.glExecuteProgramNV = GLContext.getFunctionAddress("glExecuteProgramNV")) != 0L ? 1 : 0) & ((this.glGetProgramParameterfvNV = GLContext.getFunctionAddress("glGetProgramParameterfvNV")) != 0L ? 1 : 0) & ((this.glGetProgramParameterdvNV = GLContext.getFunctionAddress("glGetProgramParameterdvNV")) != 0L ? 1 : 0) & ((this.glGetTrackMatrixivNV = GLContext.getFunctionAddress("glGetTrackMatrixivNV")) != 0L ? 1 : 0) & ((this.glGetVertexAttribfvNV = GLContext.getFunctionAddress("glGetVertexAttribfvNV")) != 0L ? 1 : 0) & ((this.glGetVertexAttribdvNV = GLContext.getFunctionAddress("glGetVertexAttribdvNV")) != 0L ? 1 : 0) & ((this.glGetVertexAttribivNV = GLContext.getFunctionAddress("glGetVertexAttribivNV")) != 0L ? 1 : 0) & ((this.glGetVertexAttribPointervNV = GLContext.getFunctionAddress("glGetVertexAttribPointervNV")) != 0L ? 1 : 0) & ((this.glProgramParameter4fNV = GLContext.getFunctionAddress("glProgramParameter4fNV")) != 0L ? 1 : 0) & ((this.glProgramParameter4dNV = GLContext.getFunctionAddress("glProgramParameter4dNV")) != 0L ? 1 : 0) & ((this.glProgramParameters4fvNV = GLContext.getFunctionAddress("glProgramParameters4fvNV")) != 0L ? 1 : 0) & ((this.glProgramParameters4dvNV = GLContext.getFunctionAddress("glProgramParameters4dvNV")) != 0L ? 1 : 0) & ((this.glTrackMatrixNV = GLContext.getFunctionAddress("glTrackMatrixNV")) != 0L ? 1 : 0) & ((this.glVertexAttribPointerNV = GLContext.getFunctionAddress("glVertexAttribPointerNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib1sNV = GLContext.getFunctionAddress("glVertexAttrib1sNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib1fNV = GLContext.getFunctionAddress("glVertexAttrib1fNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib1dNV = GLContext.getFunctionAddress("glVertexAttrib1dNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib2sNV = GLContext.getFunctionAddress("glVertexAttrib2sNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib2fNV = GLContext.getFunctionAddress("glVertexAttrib2fNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib2dNV = GLContext.getFunctionAddress("glVertexAttrib2dNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib3sNV = GLContext.getFunctionAddress("glVertexAttrib3sNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib3fNV = GLContext.getFunctionAddress("glVertexAttrib3fNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib3dNV = GLContext.getFunctionAddress("glVertexAttrib3dNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib4sNV = GLContext.getFunctionAddress("glVertexAttrib4sNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib4fNV = GLContext.getFunctionAddress("glVertexAttrib4fNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib4dNV = GLContext.getFunctionAddress("glVertexAttrib4dNV")) != 0L ? 1 : 0) & ((this.glVertexAttrib4ubNV = GLContext.getFunctionAddress("glVertexAttrib4ubNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs1svNV = GLContext.getFunctionAddress("glVertexAttribs1svNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs1fvNV = GLContext.getFunctionAddress("glVertexAttribs1fvNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs1dvNV = GLContext.getFunctionAddress("glVertexAttribs1dvNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs2svNV = GLContext.getFunctionAddress("glVertexAttribs2svNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs2fvNV = GLContext.getFunctionAddress("glVertexAttribs2fvNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs2dvNV = GLContext.getFunctionAddress("glVertexAttribs2dvNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs3svNV = GLContext.getFunctionAddress("glVertexAttribs3svNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs3fvNV = GLContext.getFunctionAddress("glVertexAttribs3fvNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs3dvNV = GLContext.getFunctionAddress("glVertexAttribs3dvNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs4svNV = GLContext.getFunctionAddress("glVertexAttribs4svNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs4fvNV = GLContext.getFunctionAddress("glVertexAttribs4fvNV")) != 0L ? 1 : 0) & ((this.glVertexAttribs4dvNV = GLContext.getFunctionAddress("glVertexAttribs4dvNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private boolean NV_video_capture_initNativeFunctionAddresses()
/*      */   {
/* 5258 */     return ((this.glBeginVideoCaptureNV = GLContext.getFunctionAddress("glBeginVideoCaptureNV")) != 0L ? 1 : 0) & ((this.glBindVideoCaptureStreamBufferNV = GLContext.getFunctionAddress("glBindVideoCaptureStreamBufferNV")) != 0L ? 1 : 0) & ((this.glBindVideoCaptureStreamTextureNV = GLContext.getFunctionAddress("glBindVideoCaptureStreamTextureNV")) != 0L ? 1 : 0) & ((this.glEndVideoCaptureNV = GLContext.getFunctionAddress("glEndVideoCaptureNV")) != 0L ? 1 : 0) & ((this.glGetVideoCaptureivNV = GLContext.getFunctionAddress("glGetVideoCaptureivNV")) != 0L ? 1 : 0) & ((this.glGetVideoCaptureStreamivNV = GLContext.getFunctionAddress("glGetVideoCaptureStreamivNV")) != 0L ? 1 : 0) & ((this.glGetVideoCaptureStreamfvNV = GLContext.getFunctionAddress("glGetVideoCaptureStreamfvNV")) != 0L ? 1 : 0) & ((this.glGetVideoCaptureStreamdvNV = GLContext.getFunctionAddress("glGetVideoCaptureStreamdvNV")) != 0L ? 1 : 0) & ((this.glVideoCaptureNV = GLContext.getFunctionAddress("glVideoCaptureNV")) != 0L ? 1 : 0) & ((this.glVideoCaptureStreamParameterivNV = GLContext.getFunctionAddress("glVideoCaptureStreamParameterivNV")) != 0L ? 1 : 0) & ((this.glVideoCaptureStreamParameterfvNV = GLContext.getFunctionAddress("glVideoCaptureStreamParameterfvNV")) != 0L ? 1 : 0) & ((this.glVideoCaptureStreamParameterdvNV = GLContext.getFunctionAddress("glVideoCaptureStreamParameterdvNV")) != 0L ? 1 : 0);
/*      */   }
/*      */ 
/*      */   private static void remove(Set supported_extensions, String extension)
/*      */   {
/* 5275 */     LWJGLUtil.log(extension + " was reported as available but an entry point is missing");
/* 5276 */     supported_extensions.remove(extension);
/*      */   }
/*      */ 
/*      */   private Set<String> initAllStubs(boolean forwardCompatible) throws LWJGLException {
/* 5280 */     this.glGetError = GLContext.getFunctionAddress("glGetError");
/* 5281 */     this.glGetString = GLContext.getFunctionAddress("glGetString");
/* 5282 */     this.glGetIntegerv = GLContext.getFunctionAddress("glGetIntegerv");
/* 5283 */     this.glGetStringi = GLContext.getFunctionAddress("glGetStringi");
/* 5284 */     GLContext.setCapabilities(this);
/* 5285 */     Set supported_extensions = new HashSet(256);
/* 5286 */     int profileMask = GLContext.getSupportedExtensions(supported_extensions);
/* 5287 */     if ((supported_extensions.contains("OpenGL31")) && (!supported_extensions.contains("GL_ARB_compatibility")) && ((profileMask & 0x2) == 0))
/* 5288 */       forwardCompatible = true;
/* 5289 */     if (!GL11_initNativeFunctionAddresses(forwardCompatible))
/* 5290 */       throw new LWJGLException("GL11 not supported");
/* 5291 */     if (supported_extensions.contains("GL_ARB_fragment_program"))
/* 5292 */       supported_extensions.add("GL_ARB_program");
/* 5293 */     if (supported_extensions.contains("GL_ARB_pixel_buffer_object"))
/* 5294 */       supported_extensions.add("GL_ARB_buffer_object");
/* 5295 */     if (supported_extensions.contains("GL_ARB_vertex_buffer_object"))
/* 5296 */       supported_extensions.add("GL_ARB_buffer_object");
/* 5297 */     if (supported_extensions.contains("GL_ARB_vertex_program"))
/* 5298 */       supported_extensions.add("GL_ARB_program");
/* 5299 */     if (supported_extensions.contains("GL_EXT_pixel_buffer_object"))
/* 5300 */       supported_extensions.add("GL_ARB_buffer_object");
/* 5301 */     if (supported_extensions.contains("GL_NV_fragment_program"))
/* 5302 */       supported_extensions.add("GL_NV_program");
/* 5303 */     if (supported_extensions.contains("GL_NV_vertex_program"))
/* 5304 */       supported_extensions.add("GL_NV_program");
/* 5305 */     if (((supported_extensions.contains("GL_AMD_debug_output")) || (supported_extensions.contains("GL_AMDX_debug_output"))) && (!AMD_debug_output_initNativeFunctionAddresses())) {
/* 5306 */       remove(supported_extensions, "GL_AMDX_debug_output");
/* 5307 */       remove(supported_extensions, "GL_AMD_debug_output");
/*      */     }
/* 5309 */     if ((supported_extensions.contains("GL_AMD_draw_buffers_blend")) && (!AMD_draw_buffers_blend_initNativeFunctionAddresses()))
/* 5310 */       remove(supported_extensions, "GL_AMD_draw_buffers_blend");
/* 5311 */     if ((supported_extensions.contains("GL_AMD_multi_draw_indirect")) && (!AMD_multi_draw_indirect_initNativeFunctionAddresses()))
/* 5312 */       remove(supported_extensions, "GL_AMD_multi_draw_indirect");
/* 5313 */     if ((supported_extensions.contains("GL_AMD_name_gen_delete")) && (!AMD_name_gen_delete_initNativeFunctionAddresses()))
/* 5314 */       remove(supported_extensions, "GL_AMD_name_gen_delete");
/* 5315 */     if ((supported_extensions.contains("GL_AMD_performance_monitor")) && (!AMD_performance_monitor_initNativeFunctionAddresses()))
/* 5316 */       remove(supported_extensions, "GL_AMD_performance_monitor");
/* 5317 */     if ((supported_extensions.contains("GL_AMD_sample_positions")) && (!AMD_sample_positions_initNativeFunctionAddresses()))
/* 5318 */       remove(supported_extensions, "GL_AMD_sample_positions");
/* 5319 */     if ((supported_extensions.contains("GL_AMD_sparse_texture")) && (!AMD_sparse_texture_initNativeFunctionAddresses()))
/* 5320 */       remove(supported_extensions, "GL_AMD_sparse_texture");
/* 5321 */     if ((supported_extensions.contains("GL_AMD_stencil_operation_extended")) && (!AMD_stencil_operation_extended_initNativeFunctionAddresses()))
/* 5322 */       remove(supported_extensions, "GL_AMD_stencil_operation_extended");
/* 5323 */     if ((supported_extensions.contains("GL_AMD_vertex_shader_tessellator")) && (!AMD_vertex_shader_tessellator_initNativeFunctionAddresses()))
/* 5324 */       remove(supported_extensions, "GL_AMD_vertex_shader_tessellator");
/* 5325 */     if ((supported_extensions.contains("GL_APPLE_element_array")) && (!APPLE_element_array_initNativeFunctionAddresses()))
/* 5326 */       remove(supported_extensions, "GL_APPLE_element_array");
/* 5327 */     if ((supported_extensions.contains("GL_APPLE_fence")) && (!APPLE_fence_initNativeFunctionAddresses()))
/* 5328 */       remove(supported_extensions, "GL_APPLE_fence");
/* 5329 */     if ((supported_extensions.contains("GL_APPLE_flush_buffer_range")) && (!APPLE_flush_buffer_range_initNativeFunctionAddresses()))
/* 5330 */       remove(supported_extensions, "GL_APPLE_flush_buffer_range");
/* 5331 */     if ((supported_extensions.contains("GL_APPLE_object_purgeable")) && (!APPLE_object_purgeable_initNativeFunctionAddresses()))
/* 5332 */       remove(supported_extensions, "GL_APPLE_object_purgeable");
/* 5333 */     if ((supported_extensions.contains("GL_APPLE_texture_range")) && (!APPLE_texture_range_initNativeFunctionAddresses()))
/* 5334 */       remove(supported_extensions, "GL_APPLE_texture_range");
/* 5335 */     if ((supported_extensions.contains("GL_APPLE_vertex_array_object")) && (!APPLE_vertex_array_object_initNativeFunctionAddresses()))
/* 5336 */       remove(supported_extensions, "GL_APPLE_vertex_array_object");
/* 5337 */     if ((supported_extensions.contains("GL_APPLE_vertex_array_range")) && (!APPLE_vertex_array_range_initNativeFunctionAddresses()))
/* 5338 */       remove(supported_extensions, "GL_APPLE_vertex_array_range");
/* 5339 */     if ((supported_extensions.contains("GL_APPLE_vertex_program_evaluators")) && (!APPLE_vertex_program_evaluators_initNativeFunctionAddresses()))
/* 5340 */       remove(supported_extensions, "GL_APPLE_vertex_program_evaluators");
/* 5341 */     if ((supported_extensions.contains("GL_ARB_ES2_compatibility")) && (!ARB_ES2_compatibility_initNativeFunctionAddresses()))
/* 5342 */       remove(supported_extensions, "GL_ARB_ES2_compatibility");
/* 5343 */     if ((supported_extensions.contains("GL_ARB_base_instance")) && (!ARB_base_instance_initNativeFunctionAddresses()))
/* 5344 */       remove(supported_extensions, "GL_ARB_base_instance");
/* 5345 */     if ((supported_extensions.contains("GL_ARB_blend_func_extended")) && (!ARB_blend_func_extended_initNativeFunctionAddresses()))
/* 5346 */       remove(supported_extensions, "GL_ARB_blend_func_extended");
/* 5347 */     if ((supported_extensions.contains("GL_ARB_buffer_object")) && (!ARB_buffer_object_initNativeFunctionAddresses()))
/* 5348 */       remove(supported_extensions, "GL_ARB_buffer_object");
/* 5349 */     if ((supported_extensions.contains("GL_ARB_cl_event")) && (!ARB_cl_event_initNativeFunctionAddresses()))
/* 5350 */       remove(supported_extensions, "GL_ARB_cl_event");
/* 5351 */     if ((supported_extensions.contains("GL_ARB_clear_buffer_object")) && (!ARB_clear_buffer_object_initNativeFunctionAddresses(supported_extensions)))
/* 5352 */       remove(supported_extensions, "GL_ARB_clear_buffer_object");
/* 5353 */     if ((supported_extensions.contains("GL_ARB_color_buffer_float")) && (!ARB_color_buffer_float_initNativeFunctionAddresses()))
/* 5354 */       remove(supported_extensions, "GL_ARB_color_buffer_float");
/* 5355 */     if ((supported_extensions.contains("GL_ARB_compute_shader")) && (!ARB_compute_shader_initNativeFunctionAddresses()))
/* 5356 */       remove(supported_extensions, "GL_ARB_compute_shader");
/* 5357 */     if ((supported_extensions.contains("GL_ARB_copy_buffer")) && (!ARB_copy_buffer_initNativeFunctionAddresses()))
/* 5358 */       remove(supported_extensions, "GL_ARB_copy_buffer");
/* 5359 */     if ((supported_extensions.contains("GL_ARB_copy_image")) && (!ARB_copy_image_initNativeFunctionAddresses()))
/* 5360 */       remove(supported_extensions, "GL_ARB_copy_image");
/* 5361 */     if ((supported_extensions.contains("GL_ARB_debug_output")) && (!ARB_debug_output_initNativeFunctionAddresses()))
/* 5362 */       remove(supported_extensions, "GL_ARB_debug_output");
/* 5363 */     if ((supported_extensions.contains("GL_ARB_draw_buffers")) && (!ARB_draw_buffers_initNativeFunctionAddresses()))
/* 5364 */       remove(supported_extensions, "GL_ARB_draw_buffers");
/* 5365 */     if ((supported_extensions.contains("GL_ARB_draw_buffers_blend")) && (!ARB_draw_buffers_blend_initNativeFunctionAddresses()))
/* 5366 */       remove(supported_extensions, "GL_ARB_draw_buffers_blend");
/* 5367 */     if ((supported_extensions.contains("GL_ARB_draw_elements_base_vertex")) && (!ARB_draw_elements_base_vertex_initNativeFunctionAddresses()))
/* 5368 */       remove(supported_extensions, "GL_ARB_draw_elements_base_vertex");
/* 5369 */     if ((supported_extensions.contains("GL_ARB_draw_indirect")) && (!ARB_draw_indirect_initNativeFunctionAddresses()))
/* 5370 */       remove(supported_extensions, "GL_ARB_draw_indirect");
/* 5371 */     if ((supported_extensions.contains("GL_ARB_draw_instanced")) && (!ARB_draw_instanced_initNativeFunctionAddresses()))
/* 5372 */       remove(supported_extensions, "GL_ARB_draw_instanced");
/* 5373 */     if ((supported_extensions.contains("GL_ARB_framebuffer_no_attachments")) && (!ARB_framebuffer_no_attachments_initNativeFunctionAddresses(supported_extensions)))
/* 5374 */       remove(supported_extensions, "GL_ARB_framebuffer_no_attachments");
/* 5375 */     if ((supported_extensions.contains("GL_ARB_framebuffer_object")) && (!ARB_framebuffer_object_initNativeFunctionAddresses()))
/* 5376 */       remove(supported_extensions, "GL_ARB_framebuffer_object");
/* 5377 */     if ((supported_extensions.contains("GL_ARB_geometry_shader4")) && (!ARB_geometry_shader4_initNativeFunctionAddresses()))
/* 5378 */       remove(supported_extensions, "GL_ARB_geometry_shader4");
/* 5379 */     if ((supported_extensions.contains("GL_ARB_get_program_binary")) && (!ARB_get_program_binary_initNativeFunctionAddresses()))
/* 5380 */       remove(supported_extensions, "GL_ARB_get_program_binary");
/* 5381 */     if ((supported_extensions.contains("GL_ARB_gpu_shader_fp64")) && (!ARB_gpu_shader_fp64_initNativeFunctionAddresses(supported_extensions)))
/* 5382 */       remove(supported_extensions, "GL_ARB_gpu_shader_fp64");
/* 5383 */     if ((supported_extensions.contains("GL_ARB_imaging")) && (!ARB_imaging_initNativeFunctionAddresses(forwardCompatible)))
/* 5384 */       remove(supported_extensions, "GL_ARB_imaging");
/* 5385 */     if ((supported_extensions.contains("GL_ARB_instanced_arrays")) && (!ARB_instanced_arrays_initNativeFunctionAddresses()))
/* 5386 */       remove(supported_extensions, "GL_ARB_instanced_arrays");
/* 5387 */     if ((supported_extensions.contains("GL_ARB_internalformat_query")) && (!ARB_internalformat_query_initNativeFunctionAddresses()))
/* 5388 */       remove(supported_extensions, "GL_ARB_internalformat_query");
/* 5389 */     if ((supported_extensions.contains("GL_ARB_internalformat_query2")) && (!ARB_internalformat_query2_initNativeFunctionAddresses()))
/* 5390 */       remove(supported_extensions, "GL_ARB_internalformat_query2");
/* 5391 */     if ((supported_extensions.contains("GL_ARB_invalidate_subdata")) && (!ARB_invalidate_subdata_initNativeFunctionAddresses()))
/* 5392 */       remove(supported_extensions, "GL_ARB_invalidate_subdata");
/* 5393 */     if ((supported_extensions.contains("GL_ARB_map_buffer_range")) && (!ARB_map_buffer_range_initNativeFunctionAddresses()))
/* 5394 */       remove(supported_extensions, "GL_ARB_map_buffer_range");
/* 5395 */     if ((supported_extensions.contains("GL_ARB_matrix_palette")) && (!ARB_matrix_palette_initNativeFunctionAddresses()))
/* 5396 */       remove(supported_extensions, "GL_ARB_matrix_palette");
/* 5397 */     if ((supported_extensions.contains("GL_ARB_multi_draw_indirect")) && (!ARB_multi_draw_indirect_initNativeFunctionAddresses()))
/* 5398 */       remove(supported_extensions, "GL_ARB_multi_draw_indirect");
/* 5399 */     if ((supported_extensions.contains("GL_ARB_multisample")) && (!ARB_multisample_initNativeFunctionAddresses()))
/* 5400 */       remove(supported_extensions, "GL_ARB_multisample");
/* 5401 */     if ((supported_extensions.contains("GL_ARB_multitexture")) && (!ARB_multitexture_initNativeFunctionAddresses()))
/* 5402 */       remove(supported_extensions, "GL_ARB_multitexture");
/* 5403 */     if ((supported_extensions.contains("GL_ARB_occlusion_query")) && (!ARB_occlusion_query_initNativeFunctionAddresses()))
/* 5404 */       remove(supported_extensions, "GL_ARB_occlusion_query");
/* 5405 */     if ((supported_extensions.contains("GL_ARB_point_parameters")) && (!ARB_point_parameters_initNativeFunctionAddresses()))
/* 5406 */       remove(supported_extensions, "GL_ARB_point_parameters");
/* 5407 */     if ((supported_extensions.contains("GL_ARB_program")) && (!ARB_program_initNativeFunctionAddresses()))
/* 5408 */       remove(supported_extensions, "GL_ARB_program");
/* 5409 */     if ((supported_extensions.contains("GL_ARB_program_interface_query")) && (!ARB_program_interface_query_initNativeFunctionAddresses()))
/* 5410 */       remove(supported_extensions, "GL_ARB_program_interface_query");
/* 5411 */     if ((supported_extensions.contains("GL_ARB_provoking_vertex")) && (!ARB_provoking_vertex_initNativeFunctionAddresses()))
/* 5412 */       remove(supported_extensions, "GL_ARB_provoking_vertex");
/* 5413 */     if ((supported_extensions.contains("GL_ARB_robustness")) && (!ARB_robustness_initNativeFunctionAddresses(forwardCompatible, supported_extensions)))
/* 5414 */       remove(supported_extensions, "GL_ARB_robustness");
/* 5415 */     if ((supported_extensions.contains("GL_ARB_sample_shading")) && (!ARB_sample_shading_initNativeFunctionAddresses()))
/* 5416 */       remove(supported_extensions, "GL_ARB_sample_shading");
/* 5417 */     if ((supported_extensions.contains("GL_ARB_sampler_objects")) && (!ARB_sampler_objects_initNativeFunctionAddresses()))
/* 5418 */       remove(supported_extensions, "GL_ARB_sampler_objects");
/* 5419 */     if ((supported_extensions.contains("GL_ARB_separate_shader_objects")) && (!ARB_separate_shader_objects_initNativeFunctionAddresses()))
/* 5420 */       remove(supported_extensions, "GL_ARB_separate_shader_objects");
/* 5421 */     if ((supported_extensions.contains("GL_ARB_shader_atomic_counters")) && (!ARB_shader_atomic_counters_initNativeFunctionAddresses()))
/* 5422 */       remove(supported_extensions, "GL_ARB_shader_atomic_counters");
/* 5423 */     if ((supported_extensions.contains("GL_ARB_shader_image_load_store")) && (!ARB_shader_image_load_store_initNativeFunctionAddresses()))
/* 5424 */       remove(supported_extensions, "GL_ARB_shader_image_load_store");
/* 5425 */     if ((supported_extensions.contains("GL_ARB_shader_objects")) && (!ARB_shader_objects_initNativeFunctionAddresses()))
/* 5426 */       remove(supported_extensions, "GL_ARB_shader_objects");
/* 5427 */     if ((supported_extensions.contains("GL_ARB_shader_storage_buffer_object")) && (!ARB_shader_storage_buffer_object_initNativeFunctionAddresses()))
/* 5428 */       remove(supported_extensions, "GL_ARB_shader_storage_buffer_object");
/* 5429 */     if ((supported_extensions.contains("GL_ARB_shader_subroutine")) && (!ARB_shader_subroutine_initNativeFunctionAddresses()))
/* 5430 */       remove(supported_extensions, "GL_ARB_shader_subroutine");
/* 5431 */     if ((supported_extensions.contains("GL_ARB_shading_language_include")) && (!ARB_shading_language_include_initNativeFunctionAddresses()))
/* 5432 */       remove(supported_extensions, "GL_ARB_shading_language_include");
/* 5433 */     if ((supported_extensions.contains("GL_ARB_sync")) && (!ARB_sync_initNativeFunctionAddresses()))
/* 5434 */       remove(supported_extensions, "GL_ARB_sync");
/* 5435 */     if ((supported_extensions.contains("GL_ARB_tessellation_shader")) && (!ARB_tessellation_shader_initNativeFunctionAddresses()))
/* 5436 */       remove(supported_extensions, "GL_ARB_tessellation_shader");
/* 5437 */     if ((supported_extensions.contains("GL_ARB_texture_buffer_object")) && (!ARB_texture_buffer_object_initNativeFunctionAddresses()))
/* 5438 */       remove(supported_extensions, "GL_ARB_texture_buffer_object");
/* 5439 */     if ((supported_extensions.contains("GL_ARB_texture_buffer_range")) && (!ARB_texture_buffer_range_initNativeFunctionAddresses(supported_extensions)))
/* 5440 */       remove(supported_extensions, "GL_ARB_texture_buffer_range");
/* 5441 */     if ((supported_extensions.contains("GL_ARB_texture_compression")) && (!ARB_texture_compression_initNativeFunctionAddresses()))
/* 5442 */       remove(supported_extensions, "GL_ARB_texture_compression");
/* 5443 */     if ((supported_extensions.contains("GL_ARB_texture_multisample")) && (!ARB_texture_multisample_initNativeFunctionAddresses()))
/* 5444 */       remove(supported_extensions, "GL_ARB_texture_multisample");
/* 5445 */     if (((supported_extensions.contains("GL_ARB_texture_storage")) || (supported_extensions.contains("GL_EXT_texture_storage"))) && (!ARB_texture_storage_initNativeFunctionAddresses(supported_extensions))) {
/* 5446 */       remove(supported_extensions, "GL_EXT_texture_storage");
/* 5447 */       remove(supported_extensions, "GL_ARB_texture_storage");
/*      */     }
/* 5449 */     if ((supported_extensions.contains("GL_ARB_texture_storage_multisample")) && (!ARB_texture_storage_multisample_initNativeFunctionAddresses(supported_extensions)))
/* 5450 */       remove(supported_extensions, "GL_ARB_texture_storage_multisample");
/* 5451 */     if ((supported_extensions.contains("GL_ARB_texture_view")) && (!ARB_texture_view_initNativeFunctionAddresses()))
/* 5452 */       remove(supported_extensions, "GL_ARB_texture_view");
/* 5453 */     if ((supported_extensions.contains("GL_ARB_timer_query")) && (!ARB_timer_query_initNativeFunctionAddresses()))
/* 5454 */       remove(supported_extensions, "GL_ARB_timer_query");
/* 5455 */     if ((supported_extensions.contains("GL_ARB_transform_feedback2")) && (!ARB_transform_feedback2_initNativeFunctionAddresses()))
/* 5456 */       remove(supported_extensions, "GL_ARB_transform_feedback2");
/* 5457 */     if ((supported_extensions.contains("GL_ARB_transform_feedback3")) && (!ARB_transform_feedback3_initNativeFunctionAddresses()))
/* 5458 */       remove(supported_extensions, "GL_ARB_transform_feedback3");
/* 5459 */     if ((supported_extensions.contains("GL_ARB_transform_feedback_instanced")) && (!ARB_transform_feedback_instanced_initNativeFunctionAddresses()))
/* 5460 */       remove(supported_extensions, "GL_ARB_transform_feedback_instanced");
/* 5461 */     if ((supported_extensions.contains("GL_ARB_transpose_matrix")) && (!ARB_transpose_matrix_initNativeFunctionAddresses()))
/* 5462 */       remove(supported_extensions, "GL_ARB_transpose_matrix");
/* 5463 */     if ((supported_extensions.contains("GL_ARB_uniform_buffer_object")) && (!ARB_uniform_buffer_object_initNativeFunctionAddresses()))
/* 5464 */       remove(supported_extensions, "GL_ARB_uniform_buffer_object");
/* 5465 */     if ((supported_extensions.contains("GL_ARB_vertex_array_object")) && (!ARB_vertex_array_object_initNativeFunctionAddresses()))
/* 5466 */       remove(supported_extensions, "GL_ARB_vertex_array_object");
/* 5467 */     if ((supported_extensions.contains("GL_ARB_vertex_attrib_64bit")) && (!ARB_vertex_attrib_64bit_initNativeFunctionAddresses(supported_extensions)))
/* 5468 */       remove(supported_extensions, "GL_ARB_vertex_attrib_64bit");
/* 5469 */     if ((supported_extensions.contains("GL_ARB_vertex_attrib_binding")) && (!ARB_vertex_attrib_binding_initNativeFunctionAddresses()))
/* 5470 */       remove(supported_extensions, "GL_ARB_vertex_attrib_binding");
/* 5471 */     if ((supported_extensions.contains("GL_ARB_vertex_blend")) && (!ARB_vertex_blend_initNativeFunctionAddresses()))
/* 5472 */       remove(supported_extensions, "GL_ARB_vertex_blend");
/* 5473 */     if ((supported_extensions.contains("GL_ARB_vertex_program")) && (!ARB_vertex_program_initNativeFunctionAddresses()))
/* 5474 */       remove(supported_extensions, "GL_ARB_vertex_program");
/* 5475 */     if ((supported_extensions.contains("GL_ARB_vertex_shader")) && (!ARB_vertex_shader_initNativeFunctionAddresses()))
/* 5476 */       remove(supported_extensions, "GL_ARB_vertex_shader");
/* 5477 */     if ((supported_extensions.contains("GL_ARB_vertex_type_2_10_10_10_rev")) && (!ARB_vertex_type_2_10_10_10_rev_initNativeFunctionAddresses()))
/* 5478 */       remove(supported_extensions, "GL_ARB_vertex_type_2_10_10_10_rev");
/* 5479 */     if ((supported_extensions.contains("GL_ARB_viewport_array")) && (!ARB_viewport_array_initNativeFunctionAddresses()))
/* 5480 */       remove(supported_extensions, "GL_ARB_viewport_array");
/* 5481 */     if ((supported_extensions.contains("GL_ARB_window_pos")) && (!ARB_window_pos_initNativeFunctionAddresses(forwardCompatible)))
/* 5482 */       remove(supported_extensions, "GL_ARB_window_pos");
/* 5483 */     if ((supported_extensions.contains("GL_ATI_draw_buffers")) && (!ATI_draw_buffers_initNativeFunctionAddresses()))
/* 5484 */       remove(supported_extensions, "GL_ATI_draw_buffers");
/* 5485 */     if ((supported_extensions.contains("GL_ATI_element_array")) && (!ATI_element_array_initNativeFunctionAddresses()))
/* 5486 */       remove(supported_extensions, "GL_ATI_element_array");
/* 5487 */     if ((supported_extensions.contains("GL_ATI_envmap_bumpmap")) && (!ATI_envmap_bumpmap_initNativeFunctionAddresses()))
/* 5488 */       remove(supported_extensions, "GL_ATI_envmap_bumpmap");
/* 5489 */     if ((supported_extensions.contains("GL_ATI_fragment_shader")) && (!ATI_fragment_shader_initNativeFunctionAddresses()))
/* 5490 */       remove(supported_extensions, "GL_ATI_fragment_shader");
/* 5491 */     if ((supported_extensions.contains("GL_ATI_map_object_buffer")) && (!ATI_map_object_buffer_initNativeFunctionAddresses()))
/* 5492 */       remove(supported_extensions, "GL_ATI_map_object_buffer");
/* 5493 */     if ((supported_extensions.contains("GL_ATI_pn_triangles")) && (!ATI_pn_triangles_initNativeFunctionAddresses()))
/* 5494 */       remove(supported_extensions, "GL_ATI_pn_triangles");
/* 5495 */     if ((supported_extensions.contains("GL_ATI_separate_stencil")) && (!ATI_separate_stencil_initNativeFunctionAddresses()))
/* 5496 */       remove(supported_extensions, "GL_ATI_separate_stencil");
/* 5497 */     if ((supported_extensions.contains("GL_ATI_vertex_array_object")) && (!ATI_vertex_array_object_initNativeFunctionAddresses()))
/* 5498 */       remove(supported_extensions, "GL_ATI_vertex_array_object");
/* 5499 */     if ((supported_extensions.contains("GL_ATI_vertex_attrib_array_object")) && (!ATI_vertex_attrib_array_object_initNativeFunctionAddresses()))
/* 5500 */       remove(supported_extensions, "GL_ATI_vertex_attrib_array_object");
/* 5501 */     if ((supported_extensions.contains("GL_ATI_vertex_streams")) && (!ATI_vertex_streams_initNativeFunctionAddresses()))
/* 5502 */       remove(supported_extensions, "GL_ATI_vertex_streams");
/* 5503 */     if ((supported_extensions.contains("GL_EXT_bindable_uniform")) && (!EXT_bindable_uniform_initNativeFunctionAddresses()))
/* 5504 */       remove(supported_extensions, "GL_EXT_bindable_uniform");
/* 5505 */     if ((supported_extensions.contains("GL_EXT_blend_color")) && (!EXT_blend_color_initNativeFunctionAddresses()))
/* 5506 */       remove(supported_extensions, "GL_EXT_blend_color");
/* 5507 */     if ((supported_extensions.contains("GL_EXT_blend_equation_separate")) && (!EXT_blend_equation_separate_initNativeFunctionAddresses()))
/* 5508 */       remove(supported_extensions, "GL_EXT_blend_equation_separate");
/* 5509 */     if ((supported_extensions.contains("GL_EXT_blend_func_separate")) && (!EXT_blend_func_separate_initNativeFunctionAddresses()))
/* 5510 */       remove(supported_extensions, "GL_EXT_blend_func_separate");
/* 5511 */     if ((supported_extensions.contains("GL_EXT_blend_minmax")) && (!EXT_blend_minmax_initNativeFunctionAddresses()))
/* 5512 */       remove(supported_extensions, "GL_EXT_blend_minmax");
/* 5513 */     if ((supported_extensions.contains("GL_EXT_compiled_vertex_array")) && (!EXT_compiled_vertex_array_initNativeFunctionAddresses()))
/* 5514 */       remove(supported_extensions, "GL_EXT_compiled_vertex_array");
/* 5515 */     if ((supported_extensions.contains("GL_EXT_depth_bounds_test")) && (!EXT_depth_bounds_test_initNativeFunctionAddresses()))
/* 5516 */       remove(supported_extensions, "GL_EXT_depth_bounds_test");
/* 5517 */     supported_extensions.add("GL_EXT_direct_state_access");
/* 5518 */     if ((supported_extensions.contains("GL_EXT_direct_state_access")) && (!EXT_direct_state_access_initNativeFunctionAddresses(forwardCompatible, supported_extensions)))
/* 5519 */       remove(supported_extensions, "GL_EXT_direct_state_access");
/* 5520 */     if ((supported_extensions.contains("GL_EXT_draw_buffers2")) && (!EXT_draw_buffers2_initNativeFunctionAddresses()))
/* 5521 */       remove(supported_extensions, "GL_EXT_draw_buffers2");
/* 5522 */     if ((supported_extensions.contains("GL_EXT_draw_instanced")) && (!EXT_draw_instanced_initNativeFunctionAddresses()))
/* 5523 */       remove(supported_extensions, "GL_EXT_draw_instanced");
/* 5524 */     if ((supported_extensions.contains("GL_EXT_draw_range_elements")) && (!EXT_draw_range_elements_initNativeFunctionAddresses()))
/* 5525 */       remove(supported_extensions, "GL_EXT_draw_range_elements");
/* 5526 */     if ((supported_extensions.contains("GL_EXT_fog_coord")) && (!EXT_fog_coord_initNativeFunctionAddresses()))
/* 5527 */       remove(supported_extensions, "GL_EXT_fog_coord");
/* 5528 */     if ((supported_extensions.contains("GL_EXT_framebuffer_blit")) && (!EXT_framebuffer_blit_initNativeFunctionAddresses()))
/* 5529 */       remove(supported_extensions, "GL_EXT_framebuffer_blit");
/* 5530 */     if ((supported_extensions.contains("GL_EXT_framebuffer_multisample")) && (!EXT_framebuffer_multisample_initNativeFunctionAddresses()))
/* 5531 */       remove(supported_extensions, "GL_EXT_framebuffer_multisample");
/* 5532 */     if ((supported_extensions.contains("GL_EXT_framebuffer_object")) && (!EXT_framebuffer_object_initNativeFunctionAddresses()))
/* 5533 */       remove(supported_extensions, "GL_EXT_framebuffer_object");
/* 5534 */     if ((supported_extensions.contains("GL_EXT_geometry_shader4")) && (!EXT_geometry_shader4_initNativeFunctionAddresses()))
/* 5535 */       remove(supported_extensions, "GL_EXT_geometry_shader4");
/* 5536 */     if ((supported_extensions.contains("GL_EXT_gpu_program_parameters")) && (!EXT_gpu_program_parameters_initNativeFunctionAddresses()))
/* 5537 */       remove(supported_extensions, "GL_EXT_gpu_program_parameters");
/* 5538 */     if ((supported_extensions.contains("GL_EXT_gpu_shader4")) && (!EXT_gpu_shader4_initNativeFunctionAddresses()))
/* 5539 */       remove(supported_extensions, "GL_EXT_gpu_shader4");
/* 5540 */     if ((supported_extensions.contains("GL_EXT_multi_draw_arrays")) && (!EXT_multi_draw_arrays_initNativeFunctionAddresses()))
/* 5541 */       remove(supported_extensions, "GL_EXT_multi_draw_arrays");
/* 5542 */     if ((supported_extensions.contains("GL_EXT_paletted_texture")) && (!EXT_paletted_texture_initNativeFunctionAddresses()))
/* 5543 */       remove(supported_extensions, "GL_EXT_paletted_texture");
/* 5544 */     if ((supported_extensions.contains("GL_EXT_point_parameters")) && (!EXT_point_parameters_initNativeFunctionAddresses()))
/* 5545 */       remove(supported_extensions, "GL_EXT_point_parameters");
/* 5546 */     if ((supported_extensions.contains("GL_EXT_provoking_vertex")) && (!EXT_provoking_vertex_initNativeFunctionAddresses()))
/* 5547 */       remove(supported_extensions, "GL_EXT_provoking_vertex");
/* 5548 */     if ((supported_extensions.contains("GL_EXT_secondary_color")) && (!EXT_secondary_color_initNativeFunctionAddresses()))
/* 5549 */       remove(supported_extensions, "GL_EXT_secondary_color");
/* 5550 */     if ((supported_extensions.contains("GL_EXT_separate_shader_objects")) && (!EXT_separate_shader_objects_initNativeFunctionAddresses()))
/* 5551 */       remove(supported_extensions, "GL_EXT_separate_shader_objects");
/* 5552 */     if ((supported_extensions.contains("GL_EXT_shader_image_load_store")) && (!EXT_shader_image_load_store_initNativeFunctionAddresses()))
/* 5553 */       remove(supported_extensions, "GL_EXT_shader_image_load_store");
/* 5554 */     if ((supported_extensions.contains("GL_EXT_stencil_clear_tag")) && (!EXT_stencil_clear_tag_initNativeFunctionAddresses()))
/* 5555 */       remove(supported_extensions, "GL_EXT_stencil_clear_tag");
/* 5556 */     if ((supported_extensions.contains("GL_EXT_stencil_two_side")) && (!EXT_stencil_two_side_initNativeFunctionAddresses()))
/* 5557 */       remove(supported_extensions, "GL_EXT_stencil_two_side");
/* 5558 */     if ((supported_extensions.contains("GL_EXT_texture_array")) && (!EXT_texture_array_initNativeFunctionAddresses()))
/* 5559 */       remove(supported_extensions, "GL_EXT_texture_array");
/* 5560 */     if ((supported_extensions.contains("GL_EXT_texture_buffer_object")) && (!EXT_texture_buffer_object_initNativeFunctionAddresses()))
/* 5561 */       remove(supported_extensions, "GL_EXT_texture_buffer_object");
/* 5562 */     if ((supported_extensions.contains("GL_EXT_texture_integer")) && (!EXT_texture_integer_initNativeFunctionAddresses()))
/* 5563 */       remove(supported_extensions, "GL_EXT_texture_integer");
/* 5564 */     if ((supported_extensions.contains("GL_EXT_timer_query")) && (!EXT_timer_query_initNativeFunctionAddresses()))
/* 5565 */       remove(supported_extensions, "GL_EXT_timer_query");
/* 5566 */     if ((supported_extensions.contains("GL_EXT_transform_feedback")) && (!EXT_transform_feedback_initNativeFunctionAddresses()))
/* 5567 */       remove(supported_extensions, "GL_EXT_transform_feedback");
/* 5568 */     if ((supported_extensions.contains("GL_EXT_vertex_attrib_64bit")) && (!EXT_vertex_attrib_64bit_initNativeFunctionAddresses(supported_extensions)))
/* 5569 */       remove(supported_extensions, "GL_EXT_vertex_attrib_64bit");
/* 5570 */     if ((supported_extensions.contains("GL_EXT_vertex_shader")) && (!EXT_vertex_shader_initNativeFunctionAddresses()))
/* 5571 */       remove(supported_extensions, "GL_EXT_vertex_shader");
/* 5572 */     if ((supported_extensions.contains("GL_EXT_vertex_weighting")) && (!EXT_vertex_weighting_initNativeFunctionAddresses()))
/* 5573 */       remove(supported_extensions, "GL_EXT_vertex_weighting");
/* 5574 */     if ((supported_extensions.contains("OpenGL12")) && (!GL12_initNativeFunctionAddresses()))
/* 5575 */       remove(supported_extensions, "OpenGL12");
/* 5576 */     if ((supported_extensions.contains("OpenGL13")) && (!GL13_initNativeFunctionAddresses(forwardCompatible)))
/* 5577 */       remove(supported_extensions, "OpenGL13");
/* 5578 */     if ((supported_extensions.contains("OpenGL14")) && (!GL14_initNativeFunctionAddresses(forwardCompatible)))
/* 5579 */       remove(supported_extensions, "OpenGL14");
/* 5580 */     if ((supported_extensions.contains("OpenGL15")) && (!GL15_initNativeFunctionAddresses()))
/* 5581 */       remove(supported_extensions, "OpenGL15");
/* 5582 */     if ((supported_extensions.contains("OpenGL20")) && (!GL20_initNativeFunctionAddresses()))
/* 5583 */       remove(supported_extensions, "OpenGL20");
/* 5584 */     if ((supported_extensions.contains("OpenGL21")) && (!GL21_initNativeFunctionAddresses()))
/* 5585 */       remove(supported_extensions, "OpenGL21");
/* 5586 */     if ((supported_extensions.contains("OpenGL30")) && (!GL30_initNativeFunctionAddresses()))
/* 5587 */       remove(supported_extensions, "OpenGL30");
/* 5588 */     if ((supported_extensions.contains("OpenGL31")) && (!GL31_initNativeFunctionAddresses()))
/* 5589 */       remove(supported_extensions, "OpenGL31");
/* 5590 */     if ((supported_extensions.contains("OpenGL32")) && (!GL32_initNativeFunctionAddresses()))
/* 5591 */       remove(supported_extensions, "OpenGL32");
/* 5592 */     if ((supported_extensions.contains("OpenGL33")) && (!GL33_initNativeFunctionAddresses(forwardCompatible)))
/* 5593 */       remove(supported_extensions, "OpenGL33");
/* 5594 */     if ((supported_extensions.contains("OpenGL40")) && (!GL40_initNativeFunctionAddresses()))
/* 5595 */       remove(supported_extensions, "OpenGL40");
/* 5596 */     if ((supported_extensions.contains("OpenGL41")) && (!GL41_initNativeFunctionAddresses()))
/* 5597 */       remove(supported_extensions, "OpenGL41");
/* 5598 */     if ((supported_extensions.contains("OpenGL42")) && (!GL42_initNativeFunctionAddresses()))
/* 5599 */       remove(supported_extensions, "OpenGL42");
/* 5600 */     if ((supported_extensions.contains("OpenGL43")) && (!GL43_initNativeFunctionAddresses()))
/* 5601 */       remove(supported_extensions, "OpenGL43");
/* 5602 */     if ((supported_extensions.contains("GL_GREMEDY_frame_terminator")) && (!GREMEDY_frame_terminator_initNativeFunctionAddresses()))
/* 5603 */       remove(supported_extensions, "GL_GREMEDY_frame_terminator");
/* 5604 */     if ((supported_extensions.contains("GL_GREMEDY_string_marker")) && (!GREMEDY_string_marker_initNativeFunctionAddresses()))
/* 5605 */       remove(supported_extensions, "GL_GREMEDY_string_marker");
/* 5606 */     if ((supported_extensions.contains("GL_INTEL_map_texture")) && (!INTEL_map_texture_initNativeFunctionAddresses()))
/* 5607 */       remove(supported_extensions, "GL_INTEL_map_texture");
/* 5608 */     if ((supported_extensions.contains("GL_KHR_debug")) && (!KHR_debug_initNativeFunctionAddresses()))
/* 5609 */       remove(supported_extensions, "GL_KHR_debug");
/* 5610 */     if ((supported_extensions.contains("GL_NV_bindless_texture")) && (!NV_bindless_texture_initNativeFunctionAddresses()))
/* 5611 */       remove(supported_extensions, "GL_NV_bindless_texture");
/* 5612 */     if ((supported_extensions.contains("GL_NV_conditional_render")) && (!NV_conditional_render_initNativeFunctionAddresses()))
/* 5613 */       remove(supported_extensions, "GL_NV_conditional_render");
/* 5614 */     if ((supported_extensions.contains("GL_NV_copy_image")) && (!NV_copy_image_initNativeFunctionAddresses()))
/* 5615 */       remove(supported_extensions, "GL_NV_copy_image");
/* 5616 */     if ((supported_extensions.contains("GL_NV_depth_buffer_float")) && (!NV_depth_buffer_float_initNativeFunctionAddresses()))
/* 5617 */       remove(supported_extensions, "GL_NV_depth_buffer_float");
/* 5618 */     if ((supported_extensions.contains("GL_NV_draw_texture")) && (!NV_draw_texture_initNativeFunctionAddresses()))
/* 5619 */       remove(supported_extensions, "GL_NV_draw_texture");
/* 5620 */     if ((supported_extensions.contains("GL_NV_evaluators")) && (!NV_evaluators_initNativeFunctionAddresses()))
/* 5621 */       remove(supported_extensions, "GL_NV_evaluators");
/* 5622 */     if ((supported_extensions.contains("GL_NV_explicit_multisample")) && (!NV_explicit_multisample_initNativeFunctionAddresses()))
/* 5623 */       remove(supported_extensions, "GL_NV_explicit_multisample");
/* 5624 */     if ((supported_extensions.contains("GL_NV_fence")) && (!NV_fence_initNativeFunctionAddresses()))
/* 5625 */       remove(supported_extensions, "GL_NV_fence");
/* 5626 */     if ((supported_extensions.contains("GL_NV_fragment_program")) && (!NV_fragment_program_initNativeFunctionAddresses()))
/* 5627 */       remove(supported_extensions, "GL_NV_fragment_program");
/* 5628 */     if ((supported_extensions.contains("GL_NV_framebuffer_multisample_coverage")) && (!NV_framebuffer_multisample_coverage_initNativeFunctionAddresses()))
/* 5629 */       remove(supported_extensions, "GL_NV_framebuffer_multisample_coverage");
/* 5630 */     if ((supported_extensions.contains("GL_NV_geometry_program4")) && (!NV_geometry_program4_initNativeFunctionAddresses()))
/* 5631 */       remove(supported_extensions, "GL_NV_geometry_program4");
/* 5632 */     if ((supported_extensions.contains("GL_NV_gpu_program4")) && (!NV_gpu_program4_initNativeFunctionAddresses()))
/* 5633 */       remove(supported_extensions, "GL_NV_gpu_program4");
/* 5634 */     if ((supported_extensions.contains("GL_NV_gpu_shader5")) && (!NV_gpu_shader5_initNativeFunctionAddresses(supported_extensions)))
/* 5635 */       remove(supported_extensions, "GL_NV_gpu_shader5");
/* 5636 */     if ((supported_extensions.contains("GL_NV_half_float")) && (!NV_half_float_initNativeFunctionAddresses()))
/* 5637 */       remove(supported_extensions, "GL_NV_half_float");
/* 5638 */     if ((supported_extensions.contains("GL_NV_occlusion_query")) && (!NV_occlusion_query_initNativeFunctionAddresses()))
/* 5639 */       remove(supported_extensions, "GL_NV_occlusion_query");
/* 5640 */     if ((supported_extensions.contains("GL_NV_parameter_buffer_object")) && (!NV_parameter_buffer_object_initNativeFunctionAddresses()))
/* 5641 */       remove(supported_extensions, "GL_NV_parameter_buffer_object");
/* 5642 */     if ((supported_extensions.contains("GL_NV_path_rendering")) && (!NV_path_rendering_initNativeFunctionAddresses()))
/* 5643 */       remove(supported_extensions, "GL_NV_path_rendering");
/* 5644 */     if ((supported_extensions.contains("GL_NV_pixel_data_range")) && (!NV_pixel_data_range_initNativeFunctionAddresses()))
/* 5645 */       remove(supported_extensions, "GL_NV_pixel_data_range");
/* 5646 */     if ((supported_extensions.contains("GL_NV_point_sprite")) && (!NV_point_sprite_initNativeFunctionAddresses()))
/* 5647 */       remove(supported_extensions, "GL_NV_point_sprite");
/* 5648 */     if ((supported_extensions.contains("GL_NV_present_video")) && (!NV_present_video_initNativeFunctionAddresses()))
/* 5649 */       remove(supported_extensions, "GL_NV_present_video");
/* 5650 */     supported_extensions.add("GL_NV_primitive_restart");
/* 5651 */     if ((supported_extensions.contains("GL_NV_primitive_restart")) && (!NV_primitive_restart_initNativeFunctionAddresses()))
/* 5652 */       remove(supported_extensions, "GL_NV_primitive_restart");
/* 5653 */     if ((supported_extensions.contains("GL_NV_program")) && (!NV_program_initNativeFunctionAddresses()))
/* 5654 */       remove(supported_extensions, "GL_NV_program");
/* 5655 */     if ((supported_extensions.contains("GL_NV_register_combiners")) && (!NV_register_combiners_initNativeFunctionAddresses()))
/* 5656 */       remove(supported_extensions, "GL_NV_register_combiners");
/* 5657 */     if ((supported_extensions.contains("GL_NV_register_combiners2")) && (!NV_register_combiners2_initNativeFunctionAddresses()))
/* 5658 */       remove(supported_extensions, "GL_NV_register_combiners2");
/* 5659 */     if ((supported_extensions.contains("GL_NV_shader_buffer_load")) && (!NV_shader_buffer_load_initNativeFunctionAddresses()))
/* 5660 */       remove(supported_extensions, "GL_NV_shader_buffer_load");
/* 5661 */     if ((supported_extensions.contains("GL_NV_texture_barrier")) && (!NV_texture_barrier_initNativeFunctionAddresses()))
/* 5662 */       remove(supported_extensions, "GL_NV_texture_barrier");
/* 5663 */     if ((supported_extensions.contains("GL_NV_texture_multisample")) && (!NV_texture_multisample_initNativeFunctionAddresses()))
/* 5664 */       remove(supported_extensions, "GL_NV_texture_multisample");
/* 5665 */     if ((supported_extensions.contains("GL_NV_transform_feedback")) && (!NV_transform_feedback_initNativeFunctionAddresses()))
/* 5666 */       remove(supported_extensions, "GL_NV_transform_feedback");
/* 5667 */     if ((supported_extensions.contains("GL_NV_transform_feedback2")) && (!NV_transform_feedback2_initNativeFunctionAddresses()))
/* 5668 */       remove(supported_extensions, "GL_NV_transform_feedback2");
/* 5669 */     if ((supported_extensions.contains("GL_NV_vertex_array_range")) && (!NV_vertex_array_range_initNativeFunctionAddresses()))
/* 5670 */       remove(supported_extensions, "GL_NV_vertex_array_range");
/* 5671 */     if ((supported_extensions.contains("GL_NV_vertex_attrib_integer_64bit")) && (!NV_vertex_attrib_integer_64bit_initNativeFunctionAddresses(supported_extensions)))
/* 5672 */       remove(supported_extensions, "GL_NV_vertex_attrib_integer_64bit");
/* 5673 */     if ((supported_extensions.contains("GL_NV_vertex_buffer_unified_memory")) && (!NV_vertex_buffer_unified_memory_initNativeFunctionAddresses()))
/* 5674 */       remove(supported_extensions, "GL_NV_vertex_buffer_unified_memory");
/* 5675 */     if ((supported_extensions.contains("GL_NV_vertex_program")) && (!NV_vertex_program_initNativeFunctionAddresses()))
/* 5676 */       remove(supported_extensions, "GL_NV_vertex_program");
/* 5677 */     if ((supported_extensions.contains("GL_NV_video_capture")) && (!NV_video_capture_initNativeFunctionAddresses()))
/* 5678 */       remove(supported_extensions, "GL_NV_video_capture");
/* 5679 */     return supported_extensions;
/*      */   }
/*      */ 
/*      */   static void unloadAllStubs() {
/*      */   }
/*      */ 
/*      */   ContextCapabilities(boolean forwardCompatible) throws LWJGLException {
/* 5686 */     Set supported_extensions = initAllStubs(forwardCompatible);
/* 5687 */     this.GL_AMD_blend_minmax_factor = supported_extensions.contains("GL_AMD_blend_minmax_factor");
/* 5688 */     this.GL_AMD_conservative_depth = supported_extensions.contains("GL_AMD_conservative_depth");
/* 5689 */     this.GL_AMD_debug_output = ((supported_extensions.contains("GL_AMD_debug_output")) || (supported_extensions.contains("GL_AMDX_debug_output")));
/*      */ 
/* 5691 */     this.GL_AMD_depth_clamp_separate = supported_extensions.contains("GL_AMD_depth_clamp_separate");
/* 5692 */     this.GL_AMD_draw_buffers_blend = supported_extensions.contains("GL_AMD_draw_buffers_blend");
/* 5693 */     this.GL_AMD_multi_draw_indirect = supported_extensions.contains("GL_AMD_multi_draw_indirect");
/* 5694 */     this.GL_AMD_name_gen_delete = supported_extensions.contains("GL_AMD_name_gen_delete");
/* 5695 */     this.GL_AMD_performance_monitor = supported_extensions.contains("GL_AMD_performance_monitor");
/* 5696 */     this.GL_AMD_pinned_memory = supported_extensions.contains("GL_AMD_pinned_memory");
/* 5697 */     this.GL_AMD_query_buffer_object = supported_extensions.contains("GL_AMD_query_buffer_object");
/* 5698 */     this.GL_AMD_sample_positions = supported_extensions.contains("GL_AMD_sample_positions");
/* 5699 */     this.GL_AMD_seamless_cubemap_per_texture = supported_extensions.contains("GL_AMD_seamless_cubemap_per_texture");
/* 5700 */     this.GL_AMD_shader_stencil_export = supported_extensions.contains("GL_AMD_shader_stencil_export");
/* 5701 */     this.GL_AMD_shader_trinary_minmax = supported_extensions.contains("GL_AMD_shader_trinary_minmax");
/* 5702 */     this.GL_AMD_sparse_texture = supported_extensions.contains("GL_AMD_sparse_texture");
/* 5703 */     this.GL_AMD_stencil_operation_extended = supported_extensions.contains("GL_AMD_stencil_operation_extended");
/* 5704 */     this.GL_AMD_texture_texture4 = supported_extensions.contains("GL_AMD_texture_texture4");
/* 5705 */     this.GL_AMD_transform_feedback3_lines_triangles = supported_extensions.contains("GL_AMD_transform_feedback3_lines_triangles");
/* 5706 */     this.GL_AMD_vertex_shader_layer = supported_extensions.contains("GL_AMD_vertex_shader_layer");
/* 5707 */     this.GL_AMD_vertex_shader_tessellator = supported_extensions.contains("GL_AMD_vertex_shader_tessellator");
/* 5708 */     this.GL_AMD_vertex_shader_viewport_index = supported_extensions.contains("GL_AMD_vertex_shader_viewport_index");
/* 5709 */     this.GL_APPLE_aux_depth_stencil = supported_extensions.contains("GL_APPLE_aux_depth_stencil");
/* 5710 */     this.GL_APPLE_client_storage = supported_extensions.contains("GL_APPLE_client_storage");
/* 5711 */     this.GL_APPLE_element_array = supported_extensions.contains("GL_APPLE_element_array");
/* 5712 */     this.GL_APPLE_fence = supported_extensions.contains("GL_APPLE_fence");
/* 5713 */     this.GL_APPLE_float_pixels = supported_extensions.contains("GL_APPLE_float_pixels");
/* 5714 */     this.GL_APPLE_flush_buffer_range = supported_extensions.contains("GL_APPLE_flush_buffer_range");
/* 5715 */     this.GL_APPLE_object_purgeable = supported_extensions.contains("GL_APPLE_object_purgeable");
/* 5716 */     this.GL_APPLE_packed_pixels = supported_extensions.contains("GL_APPLE_packed_pixels");
/* 5717 */     this.GL_APPLE_rgb_422 = supported_extensions.contains("GL_APPLE_rgb_422");
/* 5718 */     this.GL_APPLE_row_bytes = supported_extensions.contains("GL_APPLE_row_bytes");
/* 5719 */     this.GL_APPLE_texture_range = supported_extensions.contains("GL_APPLE_texture_range");
/* 5720 */     this.GL_APPLE_vertex_array_object = supported_extensions.contains("GL_APPLE_vertex_array_object");
/* 5721 */     this.GL_APPLE_vertex_array_range = supported_extensions.contains("GL_APPLE_vertex_array_range");
/* 5722 */     this.GL_APPLE_vertex_program_evaluators = supported_extensions.contains("GL_APPLE_vertex_program_evaluators");
/* 5723 */     this.GL_APPLE_ycbcr_422 = supported_extensions.contains("GL_APPLE_ycbcr_422");
/* 5724 */     this.GL_ARB_ES2_compatibility = supported_extensions.contains("GL_ARB_ES2_compatibility");
/* 5725 */     this.GL_ARB_ES3_compatibility = supported_extensions.contains("GL_ARB_ES3_compatibility");
/* 5726 */     this.GL_ARB_arrays_of_arrays = supported_extensions.contains("GL_ARB_arrays_of_arrays");
/* 5727 */     this.GL_ARB_base_instance = supported_extensions.contains("GL_ARB_base_instance");
/* 5728 */     this.GL_ARB_blend_func_extended = supported_extensions.contains("GL_ARB_blend_func_extended");
/* 5729 */     this.GL_ARB_cl_event = supported_extensions.contains("GL_ARB_cl_event");
/* 5730 */     this.GL_ARB_clear_buffer_object = supported_extensions.contains("GL_ARB_clear_buffer_object");
/* 5731 */     this.GL_ARB_color_buffer_float = supported_extensions.contains("GL_ARB_color_buffer_float");
/* 5732 */     this.GL_ARB_compatibility = supported_extensions.contains("GL_ARB_compatibility");
/* 5733 */     this.GL_ARB_compressed_texture_pixel_storage = supported_extensions.contains("GL_ARB_compressed_texture_pixel_storage");
/* 5734 */     this.GL_ARB_compute_shader = supported_extensions.contains("GL_ARB_compute_shader");
/* 5735 */     this.GL_ARB_conservative_depth = supported_extensions.contains("GL_ARB_conservative_depth");
/* 5736 */     this.GL_ARB_copy_buffer = supported_extensions.contains("GL_ARB_copy_buffer");
/* 5737 */     this.GL_ARB_copy_image = supported_extensions.contains("GL_ARB_copy_image");
/* 5738 */     this.GL_ARB_debug_output = supported_extensions.contains("GL_ARB_debug_output");
/* 5739 */     this.GL_ARB_depth_buffer_float = supported_extensions.contains("GL_ARB_depth_buffer_float");
/* 5740 */     this.GL_ARB_depth_clamp = supported_extensions.contains("GL_ARB_depth_clamp");
/* 5741 */     this.GL_ARB_depth_texture = supported_extensions.contains("GL_ARB_depth_texture");
/* 5742 */     this.GL_ARB_draw_buffers = supported_extensions.contains("GL_ARB_draw_buffers");
/* 5743 */     this.GL_ARB_draw_buffers_blend = supported_extensions.contains("GL_ARB_draw_buffers_blend");
/* 5744 */     this.GL_ARB_draw_elements_base_vertex = supported_extensions.contains("GL_ARB_draw_elements_base_vertex");
/* 5745 */     this.GL_ARB_draw_indirect = supported_extensions.contains("GL_ARB_draw_indirect");
/* 5746 */     this.GL_ARB_draw_instanced = supported_extensions.contains("GL_ARB_draw_instanced");
/* 5747 */     this.GL_ARB_explicit_attrib_location = supported_extensions.contains("GL_ARB_explicit_attrib_location");
/* 5748 */     this.GL_ARB_explicit_uniform_location = supported_extensions.contains("GL_ARB_explicit_uniform_location");
/* 5749 */     this.GL_ARB_fragment_coord_conventions = supported_extensions.contains("GL_ARB_fragment_coord_conventions");
/* 5750 */     this.GL_ARB_fragment_layer_viewport = supported_extensions.contains("GL_ARB_fragment_layer_viewport");
/* 5751 */     this.GL_ARB_fragment_program = ((supported_extensions.contains("GL_ARB_fragment_program")) && (supported_extensions.contains("GL_ARB_program")));
/*      */ 
/* 5753 */     this.GL_ARB_fragment_program_shadow = supported_extensions.contains("GL_ARB_fragment_program_shadow");
/* 5754 */     this.GL_ARB_fragment_shader = supported_extensions.contains("GL_ARB_fragment_shader");
/* 5755 */     this.GL_ARB_framebuffer_no_attachments = supported_extensions.contains("GL_ARB_framebuffer_no_attachments");
/* 5756 */     this.GL_ARB_framebuffer_object = supported_extensions.contains("GL_ARB_framebuffer_object");
/* 5757 */     this.GL_ARB_framebuffer_sRGB = supported_extensions.contains("GL_ARB_framebuffer_sRGB");
/* 5758 */     this.GL_ARB_geometry_shader4 = supported_extensions.contains("GL_ARB_geometry_shader4");
/* 5759 */     this.GL_ARB_get_program_binary = supported_extensions.contains("GL_ARB_get_program_binary");
/* 5760 */     this.GL_ARB_gpu_shader5 = supported_extensions.contains("GL_ARB_gpu_shader5");
/* 5761 */     this.GL_ARB_gpu_shader_fp64 = supported_extensions.contains("GL_ARB_gpu_shader_fp64");
/* 5762 */     this.GL_ARB_half_float_pixel = supported_extensions.contains("GL_ARB_half_float_pixel");
/* 5763 */     this.GL_ARB_half_float_vertex = supported_extensions.contains("GL_ARB_half_float_vertex");
/* 5764 */     this.GL_ARB_imaging = supported_extensions.contains("GL_ARB_imaging");
/* 5765 */     this.GL_ARB_instanced_arrays = supported_extensions.contains("GL_ARB_instanced_arrays");
/* 5766 */     this.GL_ARB_internalformat_query = supported_extensions.contains("GL_ARB_internalformat_query");
/* 5767 */     this.GL_ARB_internalformat_query2 = supported_extensions.contains("GL_ARB_internalformat_query2");
/* 5768 */     this.GL_ARB_invalidate_subdata = supported_extensions.contains("GL_ARB_invalidate_subdata");
/* 5769 */     this.GL_ARB_map_buffer_alignment = supported_extensions.contains("GL_ARB_map_buffer_alignment");
/* 5770 */     this.GL_ARB_map_buffer_range = supported_extensions.contains("GL_ARB_map_buffer_range");
/* 5771 */     this.GL_ARB_matrix_palette = supported_extensions.contains("GL_ARB_matrix_palette");
/* 5772 */     this.GL_ARB_multi_draw_indirect = supported_extensions.contains("GL_ARB_multi_draw_indirect");
/* 5773 */     this.GL_ARB_multisample = supported_extensions.contains("GL_ARB_multisample");
/* 5774 */     this.GL_ARB_multitexture = supported_extensions.contains("GL_ARB_multitexture");
/* 5775 */     this.GL_ARB_occlusion_query = supported_extensions.contains("GL_ARB_occlusion_query");
/* 5776 */     this.GL_ARB_occlusion_query2 = supported_extensions.contains("GL_ARB_occlusion_query2");
/* 5777 */     this.GL_ARB_pixel_buffer_object = ((supported_extensions.contains("GL_ARB_pixel_buffer_object")) && (supported_extensions.contains("GL_ARB_buffer_object")));
/*      */ 
/* 5779 */     this.GL_ARB_point_parameters = supported_extensions.contains("GL_ARB_point_parameters");
/* 5780 */     this.GL_ARB_point_sprite = supported_extensions.contains("GL_ARB_point_sprite");
/* 5781 */     this.GL_ARB_program_interface_query = supported_extensions.contains("GL_ARB_program_interface_query");
/* 5782 */     this.GL_ARB_provoking_vertex = supported_extensions.contains("GL_ARB_provoking_vertex");
/* 5783 */     this.GL_ARB_robust_buffer_access_behavior = supported_extensions.contains("GL_ARB_robust_buffer_access_behavior");
/* 5784 */     this.GL_ARB_robustness = supported_extensions.contains("GL_ARB_robustness");
/* 5785 */     this.GL_ARB_robustness_isolation = supported_extensions.contains("GL_ARB_robustness_isolation");
/* 5786 */     this.GL_ARB_sample_shading = supported_extensions.contains("GL_ARB_sample_shading");
/* 5787 */     this.GL_ARB_sampler_objects = supported_extensions.contains("GL_ARB_sampler_objects");
/* 5788 */     this.GL_ARB_seamless_cube_map = supported_extensions.contains("GL_ARB_seamless_cube_map");
/* 5789 */     this.GL_ARB_separate_shader_objects = supported_extensions.contains("GL_ARB_separate_shader_objects");
/* 5790 */     this.GL_ARB_shader_atomic_counters = supported_extensions.contains("GL_ARB_shader_atomic_counters");
/* 5791 */     this.GL_ARB_shader_bit_encoding = supported_extensions.contains("GL_ARB_shader_bit_encoding");
/* 5792 */     this.GL_ARB_shader_image_load_store = supported_extensions.contains("GL_ARB_shader_image_load_store");
/* 5793 */     this.GL_ARB_shader_image_size = supported_extensions.contains("GL_ARB_shader_image_size");
/* 5794 */     this.GL_ARB_shader_objects = supported_extensions.contains("GL_ARB_shader_objects");
/* 5795 */     this.GL_ARB_shader_precision = supported_extensions.contains("GL_ARB_shader_precision");
/* 5796 */     this.GL_ARB_shader_stencil_export = supported_extensions.contains("GL_ARB_shader_stencil_export");
/* 5797 */     this.GL_ARB_shader_storage_buffer_object = supported_extensions.contains("GL_ARB_shader_storage_buffer_object");
/* 5798 */     this.GL_ARB_shader_subroutine = supported_extensions.contains("GL_ARB_shader_subroutine");
/* 5799 */     this.GL_ARB_shader_texture_lod = supported_extensions.contains("GL_ARB_shader_texture_lod");
/* 5800 */     this.GL_ARB_shading_language_100 = supported_extensions.contains("GL_ARB_shading_language_100");
/* 5801 */     this.GL_ARB_shading_language_420pack = supported_extensions.contains("GL_ARB_shading_language_420pack");
/* 5802 */     this.GL_ARB_shading_language_include = supported_extensions.contains("GL_ARB_shading_language_include");
/* 5803 */     this.GL_ARB_shading_language_packing = supported_extensions.contains("GL_ARB_shading_language_packing");
/* 5804 */     this.GL_ARB_shadow = supported_extensions.contains("GL_ARB_shadow");
/* 5805 */     this.GL_ARB_shadow_ambient = supported_extensions.contains("GL_ARB_shadow_ambient");
/* 5806 */     this.GL_ARB_stencil_texturing = supported_extensions.contains("GL_ARB_stencil_texturing");
/* 5807 */     this.GL_ARB_sync = supported_extensions.contains("GL_ARB_sync");
/* 5808 */     this.GL_ARB_tessellation_shader = supported_extensions.contains("GL_ARB_tessellation_shader");
/* 5809 */     this.GL_ARB_texture_border_clamp = supported_extensions.contains("GL_ARB_texture_border_clamp");
/* 5810 */     this.GL_ARB_texture_buffer_object = supported_extensions.contains("GL_ARB_texture_buffer_object");
/* 5811 */     this.GL_ARB_texture_buffer_object_rgb32 = ((supported_extensions.contains("GL_ARB_texture_buffer_object_rgb32")) || (supported_extensions.contains("GL_EXT_texture_buffer_object_rgb32")));
/*      */ 
/* 5813 */     this.GL_ARB_texture_buffer_range = supported_extensions.contains("GL_ARB_texture_buffer_range");
/* 5814 */     this.GL_ARB_texture_compression = supported_extensions.contains("GL_ARB_texture_compression");
/* 5815 */     this.GL_ARB_texture_compression_bptc = ((supported_extensions.contains("GL_ARB_texture_compression_bptc")) || (supported_extensions.contains("GL_EXT_texture_compression_bptc")));
/*      */ 
/* 5817 */     this.GL_ARB_texture_compression_rgtc = supported_extensions.contains("GL_ARB_texture_compression_rgtc");
/* 5818 */     this.GL_ARB_texture_cube_map = supported_extensions.contains("GL_ARB_texture_cube_map");
/* 5819 */     this.GL_ARB_texture_cube_map_array = supported_extensions.contains("GL_ARB_texture_cube_map_array");
/* 5820 */     this.GL_ARB_texture_env_add = supported_extensions.contains("GL_ARB_texture_env_add");
/* 5821 */     this.GL_ARB_texture_env_combine = supported_extensions.contains("GL_ARB_texture_env_combine");
/* 5822 */     this.GL_ARB_texture_env_crossbar = supported_extensions.contains("GL_ARB_texture_env_crossbar");
/* 5823 */     this.GL_ARB_texture_env_dot3 = supported_extensions.contains("GL_ARB_texture_env_dot3");
/* 5824 */     this.GL_ARB_texture_float = supported_extensions.contains("GL_ARB_texture_float");
/* 5825 */     this.GL_ARB_texture_gather = supported_extensions.contains("GL_ARB_texture_gather");
/* 5826 */     this.GL_ARB_texture_mirrored_repeat = supported_extensions.contains("GL_ARB_texture_mirrored_repeat");
/* 5827 */     this.GL_ARB_texture_multisample = supported_extensions.contains("GL_ARB_texture_multisample");
/* 5828 */     this.GL_ARB_texture_non_power_of_two = supported_extensions.contains("GL_ARB_texture_non_power_of_two");
/* 5829 */     this.GL_ARB_texture_query_levels = supported_extensions.contains("GL_ARB_texture_query_levels");
/* 5830 */     this.GL_ARB_texture_query_lod = supported_extensions.contains("GL_ARB_texture_query_lod");
/* 5831 */     this.GL_ARB_texture_rectangle = supported_extensions.contains("GL_ARB_texture_rectangle");
/* 5832 */     this.GL_ARB_texture_rg = supported_extensions.contains("GL_ARB_texture_rg");
/* 5833 */     this.GL_ARB_texture_rgb10_a2ui = supported_extensions.contains("GL_ARB_texture_rgb10_a2ui");
/* 5834 */     this.GL_ARB_texture_storage = ((supported_extensions.contains("GL_ARB_texture_storage")) || (supported_extensions.contains("GL_EXT_texture_storage")));
/*      */ 
/* 5836 */     this.GL_ARB_texture_storage_multisample = supported_extensions.contains("GL_ARB_texture_storage_multisample");
/* 5837 */     this.GL_ARB_texture_swizzle = supported_extensions.contains("GL_ARB_texture_swizzle");
/* 5838 */     this.GL_ARB_texture_view = supported_extensions.contains("GL_ARB_texture_view");
/* 5839 */     this.GL_ARB_timer_query = supported_extensions.contains("GL_ARB_timer_query");
/* 5840 */     this.GL_ARB_transform_feedback2 = supported_extensions.contains("GL_ARB_transform_feedback2");
/* 5841 */     this.GL_ARB_transform_feedback3 = supported_extensions.contains("GL_ARB_transform_feedback3");
/* 5842 */     this.GL_ARB_transform_feedback_instanced = supported_extensions.contains("GL_ARB_transform_feedback_instanced");
/* 5843 */     this.GL_ARB_transpose_matrix = supported_extensions.contains("GL_ARB_transpose_matrix");
/* 5844 */     this.GL_ARB_uniform_buffer_object = supported_extensions.contains("GL_ARB_uniform_buffer_object");
/* 5845 */     this.GL_ARB_vertex_array_bgra = supported_extensions.contains("GL_ARB_vertex_array_bgra");
/* 5846 */     this.GL_ARB_vertex_array_object = supported_extensions.contains("GL_ARB_vertex_array_object");
/* 5847 */     this.GL_ARB_vertex_attrib_64bit = supported_extensions.contains("GL_ARB_vertex_attrib_64bit");
/* 5848 */     this.GL_ARB_vertex_attrib_binding = supported_extensions.contains("GL_ARB_vertex_attrib_binding");
/* 5849 */     this.GL_ARB_vertex_blend = supported_extensions.contains("GL_ARB_vertex_blend");
/* 5850 */     this.GL_ARB_vertex_buffer_object = ((supported_extensions.contains("GL_ARB_vertex_buffer_object")) && (supported_extensions.contains("GL_ARB_buffer_object")));
/*      */ 
/* 5852 */     this.GL_ARB_vertex_program = ((supported_extensions.contains("GL_ARB_vertex_program")) && (supported_extensions.contains("GL_ARB_program")));
/*      */ 
/* 5854 */     this.GL_ARB_vertex_shader = supported_extensions.contains("GL_ARB_vertex_shader");
/* 5855 */     this.GL_ARB_vertex_type_2_10_10_10_rev = supported_extensions.contains("GL_ARB_vertex_type_2_10_10_10_rev");
/* 5856 */     this.GL_ARB_viewport_array = supported_extensions.contains("GL_ARB_viewport_array");
/* 5857 */     this.GL_ARB_window_pos = supported_extensions.contains("GL_ARB_window_pos");
/* 5858 */     this.GL_ATI_draw_buffers = supported_extensions.contains("GL_ATI_draw_buffers");
/* 5859 */     this.GL_ATI_element_array = supported_extensions.contains("GL_ATI_element_array");
/* 5860 */     this.GL_ATI_envmap_bumpmap = supported_extensions.contains("GL_ATI_envmap_bumpmap");
/* 5861 */     this.GL_ATI_fragment_shader = supported_extensions.contains("GL_ATI_fragment_shader");
/* 5862 */     this.GL_ATI_map_object_buffer = supported_extensions.contains("GL_ATI_map_object_buffer");
/* 5863 */     this.GL_ATI_meminfo = supported_extensions.contains("GL_ATI_meminfo");
/* 5864 */     this.GL_ATI_pn_triangles = supported_extensions.contains("GL_ATI_pn_triangles");
/* 5865 */     this.GL_ATI_separate_stencil = supported_extensions.contains("GL_ATI_separate_stencil");
/* 5866 */     this.GL_ATI_shader_texture_lod = supported_extensions.contains("GL_ATI_shader_texture_lod");
/* 5867 */     this.GL_ATI_text_fragment_shader = supported_extensions.contains("GL_ATI_text_fragment_shader");
/* 5868 */     this.GL_ATI_texture_compression_3dc = supported_extensions.contains("GL_ATI_texture_compression_3dc");
/* 5869 */     this.GL_ATI_texture_env_combine3 = supported_extensions.contains("GL_ATI_texture_env_combine3");
/* 5870 */     this.GL_ATI_texture_float = supported_extensions.contains("GL_ATI_texture_float");
/* 5871 */     this.GL_ATI_texture_mirror_once = supported_extensions.contains("GL_ATI_texture_mirror_once");
/* 5872 */     this.GL_ATI_vertex_array_object = supported_extensions.contains("GL_ATI_vertex_array_object");
/* 5873 */     this.GL_ATI_vertex_attrib_array_object = supported_extensions.contains("GL_ATI_vertex_attrib_array_object");
/* 5874 */     this.GL_ATI_vertex_streams = supported_extensions.contains("GL_ATI_vertex_streams");
/* 5875 */     this.GL_EXT_abgr = supported_extensions.contains("GL_EXT_abgr");
/* 5876 */     this.GL_EXT_bgra = supported_extensions.contains("GL_EXT_bgra");
/* 5877 */     this.GL_EXT_bindable_uniform = supported_extensions.contains("GL_EXT_bindable_uniform");
/* 5878 */     this.GL_EXT_blend_color = supported_extensions.contains("GL_EXT_blend_color");
/* 5879 */     this.GL_EXT_blend_equation_separate = supported_extensions.contains("GL_EXT_blend_equation_separate");
/* 5880 */     this.GL_EXT_blend_func_separate = supported_extensions.contains("GL_EXT_blend_func_separate");
/* 5881 */     this.GL_EXT_blend_minmax = supported_extensions.contains("GL_EXT_blend_minmax");
/* 5882 */     this.GL_EXT_blend_subtract = supported_extensions.contains("GL_EXT_blend_subtract");
/* 5883 */     this.GL_EXT_Cg_shader = supported_extensions.contains("GL_EXT_Cg_shader");
/* 5884 */     this.GL_EXT_compiled_vertex_array = supported_extensions.contains("GL_EXT_compiled_vertex_array");
/* 5885 */     this.GL_EXT_depth_bounds_test = supported_extensions.contains("GL_EXT_depth_bounds_test");
/* 5886 */     this.GL_EXT_direct_state_access = supported_extensions.contains("GL_EXT_direct_state_access");
/* 5887 */     this.GL_EXT_draw_buffers2 = supported_extensions.contains("GL_EXT_draw_buffers2");
/* 5888 */     this.GL_EXT_draw_instanced = supported_extensions.contains("GL_EXT_draw_instanced");
/* 5889 */     this.GL_EXT_draw_range_elements = supported_extensions.contains("GL_EXT_draw_range_elements");
/* 5890 */     this.GL_EXT_fog_coord = supported_extensions.contains("GL_EXT_fog_coord");
/* 5891 */     this.GL_EXT_framebuffer_blit = supported_extensions.contains("GL_EXT_framebuffer_blit");
/* 5892 */     this.GL_EXT_framebuffer_multisample = supported_extensions.contains("GL_EXT_framebuffer_multisample");
/* 5893 */     this.GL_EXT_framebuffer_multisample_blit_scaled = supported_extensions.contains("GL_EXT_framebuffer_multisample_blit_scaled");
/* 5894 */     this.GL_EXT_framebuffer_object = supported_extensions.contains("GL_EXT_framebuffer_object");
/* 5895 */     this.GL_EXT_framebuffer_sRGB = supported_extensions.contains("GL_EXT_framebuffer_sRGB");
/* 5896 */     this.GL_EXT_geometry_shader4 = supported_extensions.contains("GL_EXT_geometry_shader4");
/* 5897 */     this.GL_EXT_gpu_program_parameters = supported_extensions.contains("GL_EXT_gpu_program_parameters");
/* 5898 */     this.GL_EXT_gpu_shader4 = supported_extensions.contains("GL_EXT_gpu_shader4");
/* 5899 */     this.GL_EXT_multi_draw_arrays = supported_extensions.contains("GL_EXT_multi_draw_arrays");
/* 5900 */     this.GL_EXT_packed_depth_stencil = supported_extensions.contains("GL_EXT_packed_depth_stencil");
/* 5901 */     this.GL_EXT_packed_float = supported_extensions.contains("GL_EXT_packed_float");
/* 5902 */     this.GL_EXT_packed_pixels = supported_extensions.contains("GL_EXT_packed_pixels");
/* 5903 */     this.GL_EXT_paletted_texture = supported_extensions.contains("GL_EXT_paletted_texture");
/* 5904 */     this.GL_EXT_pixel_buffer_object = ((supported_extensions.contains("GL_EXT_pixel_buffer_object")) && (supported_extensions.contains("GL_ARB_buffer_object")));
/*      */ 
/* 5906 */     this.GL_EXT_point_parameters = supported_extensions.contains("GL_EXT_point_parameters");
/* 5907 */     this.GL_EXT_provoking_vertex = supported_extensions.contains("GL_EXT_provoking_vertex");
/* 5908 */     this.GL_EXT_rescale_normal = supported_extensions.contains("GL_EXT_rescale_normal");
/* 5909 */     this.GL_EXT_secondary_color = supported_extensions.contains("GL_EXT_secondary_color");
/* 5910 */     this.GL_EXT_separate_shader_objects = supported_extensions.contains("GL_EXT_separate_shader_objects");
/* 5911 */     this.GL_EXT_separate_specular_color = supported_extensions.contains("GL_EXT_separate_specular_color");
/* 5912 */     this.GL_EXT_shader_image_load_store = supported_extensions.contains("GL_EXT_shader_image_load_store");
/* 5913 */     this.GL_EXT_shadow_funcs = supported_extensions.contains("GL_EXT_shadow_funcs");
/* 5914 */     this.GL_EXT_shared_texture_palette = supported_extensions.contains("GL_EXT_shared_texture_palette");
/* 5915 */     this.GL_EXT_stencil_clear_tag = supported_extensions.contains("GL_EXT_stencil_clear_tag");
/* 5916 */     this.GL_EXT_stencil_two_side = supported_extensions.contains("GL_EXT_stencil_two_side");
/* 5917 */     this.GL_EXT_stencil_wrap = supported_extensions.contains("GL_EXT_stencil_wrap");
/* 5918 */     this.GL_EXT_texture_3d = supported_extensions.contains("GL_EXT_texture_3d");
/* 5919 */     this.GL_EXT_texture_array = supported_extensions.contains("GL_EXT_texture_array");
/* 5920 */     this.GL_EXT_texture_buffer_object = supported_extensions.contains("GL_EXT_texture_buffer_object");
/* 5921 */     this.GL_EXT_texture_compression_latc = supported_extensions.contains("GL_EXT_texture_compression_latc");
/* 5922 */     this.GL_EXT_texture_compression_rgtc = supported_extensions.contains("GL_EXT_texture_compression_rgtc");
/* 5923 */     this.GL_EXT_texture_compression_s3tc = supported_extensions.contains("GL_EXT_texture_compression_s3tc");
/* 5924 */     this.GL_EXT_texture_env_combine = supported_extensions.contains("GL_EXT_texture_env_combine");
/* 5925 */     this.GL_EXT_texture_env_dot3 = supported_extensions.contains("GL_EXT_texture_env_dot3");
/* 5926 */     this.GL_EXT_texture_filter_anisotropic = supported_extensions.contains("GL_EXT_texture_filter_anisotropic");
/* 5927 */     this.GL_EXT_texture_integer = supported_extensions.contains("GL_EXT_texture_integer");
/* 5928 */     this.GL_EXT_texture_lod_bias = supported_extensions.contains("GL_EXT_texture_lod_bias");
/* 5929 */     this.GL_EXT_texture_mirror_clamp = supported_extensions.contains("GL_EXT_texture_mirror_clamp");
/* 5930 */     this.GL_EXT_texture_rectangle = supported_extensions.contains("GL_EXT_texture_rectangle");
/* 5931 */     this.GL_EXT_texture_sRGB = supported_extensions.contains("GL_EXT_texture_sRGB");
/* 5932 */     this.GL_EXT_texture_sRGB_decode = supported_extensions.contains("GL_EXT_texture_sRGB_decode");
/* 5933 */     this.GL_EXT_texture_shared_exponent = supported_extensions.contains("GL_EXT_texture_shared_exponent");
/* 5934 */     this.GL_EXT_texture_snorm = supported_extensions.contains("GL_EXT_texture_snorm");
/* 5935 */     this.GL_EXT_texture_swizzle = supported_extensions.contains("GL_EXT_texture_swizzle");
/* 5936 */     this.GL_EXT_timer_query = supported_extensions.contains("GL_EXT_timer_query");
/* 5937 */     this.GL_EXT_transform_feedback = supported_extensions.contains("GL_EXT_transform_feedback");
/* 5938 */     this.GL_EXT_vertex_array_bgra = supported_extensions.contains("GL_EXT_vertex_array_bgra");
/* 5939 */     this.GL_EXT_vertex_attrib_64bit = supported_extensions.contains("GL_EXT_vertex_attrib_64bit");
/* 5940 */     this.GL_EXT_vertex_shader = supported_extensions.contains("GL_EXT_vertex_shader");
/* 5941 */     this.GL_EXT_vertex_weighting = supported_extensions.contains("GL_EXT_vertex_weighting");
/* 5942 */     this.OpenGL11 = supported_extensions.contains("OpenGL11");
/* 5943 */     this.OpenGL12 = supported_extensions.contains("OpenGL12");
/* 5944 */     this.OpenGL13 = supported_extensions.contains("OpenGL13");
/* 5945 */     this.OpenGL14 = supported_extensions.contains("OpenGL14");
/* 5946 */     this.OpenGL15 = supported_extensions.contains("OpenGL15");
/* 5947 */     this.OpenGL20 = supported_extensions.contains("OpenGL20");
/* 5948 */     this.OpenGL21 = supported_extensions.contains("OpenGL21");
/* 5949 */     this.OpenGL30 = supported_extensions.contains("OpenGL30");
/* 5950 */     this.OpenGL31 = supported_extensions.contains("OpenGL31");
/* 5951 */     this.OpenGL32 = supported_extensions.contains("OpenGL32");
/* 5952 */     this.OpenGL33 = supported_extensions.contains("OpenGL33");
/* 5953 */     this.OpenGL40 = supported_extensions.contains("OpenGL40");
/* 5954 */     this.OpenGL41 = supported_extensions.contains("OpenGL41");
/* 5955 */     this.OpenGL42 = supported_extensions.contains("OpenGL42");
/* 5956 */     this.OpenGL43 = supported_extensions.contains("OpenGL43");
/* 5957 */     this.GL_GREMEDY_frame_terminator = supported_extensions.contains("GL_GREMEDY_frame_terminator");
/* 5958 */     this.GL_GREMEDY_string_marker = supported_extensions.contains("GL_GREMEDY_string_marker");
/* 5959 */     this.GL_HP_occlusion_test = supported_extensions.contains("GL_HP_occlusion_test");
/* 5960 */     this.GL_IBM_rasterpos_clip = supported_extensions.contains("GL_IBM_rasterpos_clip");
/* 5961 */     this.GL_INTEL_map_texture = supported_extensions.contains("GL_INTEL_map_texture");
/* 5962 */     this.GL_KHR_debug = supported_extensions.contains("GL_KHR_debug");
/* 5963 */     this.GL_KHR_texture_compression_astc_ldr = supported_extensions.contains("GL_KHR_texture_compression_astc_ldr");
/* 5964 */     this.GL_NVX_gpu_memory_info = supported_extensions.contains("GL_NVX_gpu_memory_info");
/* 5965 */     this.GL_NV_bindless_texture = supported_extensions.contains("GL_NV_bindless_texture");
/* 5966 */     this.GL_NV_blend_square = supported_extensions.contains("GL_NV_blend_square");
/* 5967 */     this.GL_NV_compute_program5 = supported_extensions.contains("GL_NV_compute_program5");
/* 5968 */     this.GL_NV_conditional_render = supported_extensions.contains("GL_NV_conditional_render");
/* 5969 */     this.GL_NV_copy_depth_to_color = supported_extensions.contains("GL_NV_copy_depth_to_color");
/* 5970 */     this.GL_NV_copy_image = supported_extensions.contains("GL_NV_copy_image");
/* 5971 */     this.GL_NV_deep_texture3D = supported_extensions.contains("GL_NV_deep_texture3D");
/* 5972 */     this.GL_NV_depth_buffer_float = supported_extensions.contains("GL_NV_depth_buffer_float");
/* 5973 */     this.GL_NV_depth_clamp = supported_extensions.contains("GL_NV_depth_clamp");
/* 5974 */     this.GL_NV_draw_texture = supported_extensions.contains("GL_NV_draw_texture");
/* 5975 */     this.GL_NV_evaluators = supported_extensions.contains("GL_NV_evaluators");
/* 5976 */     this.GL_NV_explicit_multisample = supported_extensions.contains("GL_NV_explicit_multisample");
/* 5977 */     this.GL_NV_fence = supported_extensions.contains("GL_NV_fence");
/* 5978 */     this.GL_NV_float_buffer = supported_extensions.contains("GL_NV_float_buffer");
/* 5979 */     this.GL_NV_fog_distance = supported_extensions.contains("GL_NV_fog_distance");
/* 5980 */     this.GL_NV_fragment_program = ((supported_extensions.contains("GL_NV_fragment_program")) && (supported_extensions.contains("GL_NV_program")));
/*      */ 
/* 5982 */     this.GL_NV_fragment_program2 = supported_extensions.contains("GL_NV_fragment_program2");
/* 5983 */     this.GL_NV_fragment_program4 = supported_extensions.contains("GL_NV_fragment_program4");
/* 5984 */     this.GL_NV_fragment_program_option = supported_extensions.contains("GL_NV_fragment_program_option");
/* 5985 */     this.GL_NV_framebuffer_multisample_coverage = supported_extensions.contains("GL_NV_framebuffer_multisample_coverage");
/* 5986 */     this.GL_NV_geometry_program4 = supported_extensions.contains("GL_NV_geometry_program4");
/* 5987 */     this.GL_NV_geometry_shader4 = supported_extensions.contains("GL_NV_geometry_shader4");
/* 5988 */     this.GL_NV_gpu_program4 = supported_extensions.contains("GL_NV_gpu_program4");
/* 5989 */     this.GL_NV_gpu_program5 = supported_extensions.contains("GL_NV_gpu_program5");
/* 5990 */     this.GL_NV_gpu_shader5 = supported_extensions.contains("GL_NV_gpu_shader5");
/* 5991 */     this.GL_NV_half_float = supported_extensions.contains("GL_NV_half_float");
/* 5992 */     this.GL_NV_light_max_exponent = supported_extensions.contains("GL_NV_light_max_exponent");
/* 5993 */     this.GL_NV_multisample_coverage = supported_extensions.contains("GL_NV_multisample_coverage");
/* 5994 */     this.GL_NV_multisample_filter_hint = supported_extensions.contains("GL_NV_multisample_filter_hint");
/* 5995 */     this.GL_NV_occlusion_query = supported_extensions.contains("GL_NV_occlusion_query");
/* 5996 */     this.GL_NV_packed_depth_stencil = supported_extensions.contains("GL_NV_packed_depth_stencil");
/* 5997 */     this.GL_NV_parameter_buffer_object = supported_extensions.contains("GL_NV_parameter_buffer_object");
/* 5998 */     this.GL_NV_parameter_buffer_object2 = supported_extensions.contains("GL_NV_parameter_buffer_object2");
/* 5999 */     this.GL_NV_path_rendering = supported_extensions.contains("GL_NV_path_rendering");
/* 6000 */     this.GL_NV_pixel_data_range = supported_extensions.contains("GL_NV_pixel_data_range");
/* 6001 */     this.GL_NV_point_sprite = supported_extensions.contains("GL_NV_point_sprite");
/* 6002 */     this.GL_NV_present_video = supported_extensions.contains("GL_NV_present_video");
/* 6003 */     this.GL_NV_primitive_restart = supported_extensions.contains("GL_NV_primitive_restart");
/* 6004 */     this.GL_NV_register_combiners = supported_extensions.contains("GL_NV_register_combiners");
/* 6005 */     this.GL_NV_register_combiners2 = supported_extensions.contains("GL_NV_register_combiners2");
/* 6006 */     this.GL_NV_shader_atomic_counters = supported_extensions.contains("GL_NV_shader_atomic_counters");
/* 6007 */     this.GL_NV_shader_atomic_float = supported_extensions.contains("GL_NV_shader_atomic_float");
/* 6008 */     this.GL_NV_shader_buffer_load = supported_extensions.contains("GL_NV_shader_buffer_load");
/* 6009 */     this.GL_NV_shader_buffer_store = supported_extensions.contains("GL_NV_shader_buffer_store");
/* 6010 */     this.GL_NV_shader_storage_buffer_object = supported_extensions.contains("GL_NV_shader_storage_buffer_object");
/* 6011 */     this.GL_NV_tessellation_program5 = supported_extensions.contains("GL_NV_tessellation_program5");
/* 6012 */     this.GL_NV_texgen_reflection = supported_extensions.contains("GL_NV_texgen_reflection");
/* 6013 */     this.GL_NV_texture_barrier = supported_extensions.contains("GL_NV_texture_barrier");
/* 6014 */     this.GL_NV_texture_compression_vtc = supported_extensions.contains("GL_NV_texture_compression_vtc");
/* 6015 */     this.GL_NV_texture_env_combine4 = supported_extensions.contains("GL_NV_texture_env_combine4");
/* 6016 */     this.GL_NV_texture_expand_normal = supported_extensions.contains("GL_NV_texture_expand_normal");
/* 6017 */     this.GL_NV_texture_multisample = supported_extensions.contains("GL_NV_texture_multisample");
/* 6018 */     this.GL_NV_texture_rectangle = supported_extensions.contains("GL_NV_texture_rectangle");
/* 6019 */     this.GL_NV_texture_shader = supported_extensions.contains("GL_NV_texture_shader");
/* 6020 */     this.GL_NV_texture_shader2 = supported_extensions.contains("GL_NV_texture_shader2");
/* 6021 */     this.GL_NV_texture_shader3 = supported_extensions.contains("GL_NV_texture_shader3");
/* 6022 */     this.GL_NV_transform_feedback = supported_extensions.contains("GL_NV_transform_feedback");
/* 6023 */     this.GL_NV_transform_feedback2 = supported_extensions.contains("GL_NV_transform_feedback2");
/* 6024 */     this.GL_NV_vertex_array_range = supported_extensions.contains("GL_NV_vertex_array_range");
/* 6025 */     this.GL_NV_vertex_array_range2 = supported_extensions.contains("GL_NV_vertex_array_range2");
/* 6026 */     this.GL_NV_vertex_attrib_integer_64bit = supported_extensions.contains("GL_NV_vertex_attrib_integer_64bit");
/* 6027 */     this.GL_NV_vertex_buffer_unified_memory = supported_extensions.contains("GL_NV_vertex_buffer_unified_memory");
/* 6028 */     this.GL_NV_vertex_program = ((supported_extensions.contains("GL_NV_vertex_program")) && (supported_extensions.contains("GL_NV_program")));
/*      */ 
/* 6030 */     this.GL_NV_vertex_program1_1 = supported_extensions.contains("GL_NV_vertex_program1_1");
/* 6031 */     this.GL_NV_vertex_program2 = supported_extensions.contains("GL_NV_vertex_program2");
/* 6032 */     this.GL_NV_vertex_program2_option = supported_extensions.contains("GL_NV_vertex_program2_option");
/* 6033 */     this.GL_NV_vertex_program3 = supported_extensions.contains("GL_NV_vertex_program3");
/* 6034 */     this.GL_NV_vertex_program4 = supported_extensions.contains("GL_NV_vertex_program4");
/* 6035 */     this.GL_NV_video_capture = supported_extensions.contains("GL_NV_video_capture");
/* 6036 */     this.GL_SGIS_generate_mipmap = supported_extensions.contains("GL_SGIS_generate_mipmap");
/* 6037 */     this.GL_SGIS_texture_lod = supported_extensions.contains("GL_SGIS_texture_lod");
/* 6038 */     this.GL_SUN_slice_accum = supported_extensions.contains("GL_SUN_slice_accum");
/* 6039 */     this.tracker.init();
/*      */   }
/*      */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.lwjgl.opengl.ContextCapabilities
 * JD-Core Version:    0.6.2
 */