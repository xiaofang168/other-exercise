module.exports = (grunt) ->
	grunt.initConfig
		pkg: grunt.file.readJSON 'package.json'

		uglify:
			options:
				banner: '/*! <%= pkg.name %> mailto:fangjie1@hikvision.com.cn <%= grunt.template.today("yyyy-mm-dd") %> */\n'
			product: 
				src: 'product/src/*.js'
				dest: 'product/dist/'
				expand: true
				flatten: true
				ext: '.js'
		
		concat:
			product:
				files:
					'product/src/baiduEmap.js': ['product/src/baiduEmap.js', 'development/baidu/imgReady.js','development/baidu/DistanceTool_min.js','development/base64.js']
					'product/src/googleEmap.js': ['product/src/googleEmap.js', 'development/google/snapshotcontrol.js','development/base64.js']

		coffee: 
			development:
				options:
					bare: true
				files:
					'product/src/emap.js': 'development/emap.coffee'
					'product/src/baiduEmap.js': ['development/baidu/*.coffee','development/display.coffee','development/sysConfig.coffee','development/utils.coffee']
					'product/src/googleEmap.js': ['development/google/*.coffee','development/display.coffee','development/sysConfig.coffee','development/utils.coffee']
					'product/src/wapianEmap.js': ['development/wapian/*.coffee','development/display.coffee','development/sysConfig.coffee','development/utils.coffee']
		clean:
			app:
				src: ['product/src/*.js','product/dist/*.js']

		watch: 
			coffee:
				files: ['development/**/*.coffee']
				tasks: ['clean:app','coffee:development','concat:product']
			js:
				files: ['product/src/*.js']
				tasks: ['uglify:product']

	grunt.loadNpmTasks 'grunt-contrib-uglify'
	grunt.loadNpmTasks 'grunt-contrib-concat'
	grunt.loadNpmTasks 'grunt-contrib-coffee'
	grunt.loadNpmTasks 'grunt-contrib-watch'
	grunt.loadNpmTasks 'grunt-contrib-clean'

	grunt.registerTask 'default',['clean:app','coffee:development','concat:product','uglify:product','watch']