module.exports = (grunt) ->
# init here
 	grunt.initConfig
    pkg: grunt.file.readJSON 'package.json'
    
    uglify:
      options:
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
      ,
      app: 
        src: 'src/*.js'
        dest: 'build/'
        expand: true
        flatten: true
        ext: '.min.js'
      user:
        src: 'src/user/*.js'
        dest: 'build/user/'
        expand: true
        flatten: true
        ext: '.min.js'
       
    coffee: 
        app: 
            expand: true
            flatten: true
            options:
              bare: true
            src: 'src/*.coffee'
            dest: 'src/'
            ext: '.js'
        user:
            expand: true
            flatten: true
            options:
              bare: true
            src: 'src/user/*.coffee'
            dest: 'src/user/'
            ext: '.js'
            
    clean: ["src/*.js", "src/user/*.js"]
    
    watch: 
        js:  
          files: ['src/*.coffee','src/user/*.coffee']
          tasks: ['coffee','uglify','clean']
    
        
  grunt.loadNpmTasks 'grunt-contrib-uglify'
  grunt.loadNpmTasks 'grunt-contrib-coffee'
  grunt.loadNpmTasks 'grunt-contrib-watch'
  grunt.loadNpmTasks 'grunt-contrib-clean'

  grunt.registerTask 'default', ['coffee','uglify','clean','watch']
