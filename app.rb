require 'rubygems'
require 'sinatra'
require 'mysql2'

# this takes a hash of options, almost all of which map directly
# to the familiar database.yml in rails
# See http://api.rubyonrails.org/classes/ActiveRecord/ConnectionAdapters/MysqlAdapter.html

client = Mysql2::Client.new(:host => "localhost", :username => "root", :password => "root", :encoding => "utf8",
						 :database => "treasurehunter", :socket => "/Applications/MAMP/tmp/mysql/mysql.sock")

get '/' do
	"Hello from Sinatra on Heroku!"
end

get '/hello/:name' do
	result = client.query("SELECT * FROM users")

	#result.each do |row|
    #	"Result: #{result}"
    #end

	result.to_s
end
