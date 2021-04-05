#pragma once
#include <iostream>
#include <set>
#include <stack>
#include <vector>


using namespace std;
class CourseSchedule
{
public:
	class Digraph {

		vector<set<int>> edges;
		int V, E;
	public:
		Digraph(int V)
		{
			this->V = V;
			this->E = E;

			//edges = vector<set<int>>();

			for (int i = 0; i < V; i++)
			{
				edges.push_back(set<int>());
			}
		}
		int Vertices()
		{
			return V;
		}
		int Edges()
		{
			return E;
		}

		void addEdge(int v, int w)
		{
			edges[v].insert(w);
			E++;
		}
		set<int> adj(int v)
		{
			return edges[v];
		}
	};

	class DirectedCycle
	{
		vector<bool> marked, onStack;
		vector<int> edgeTo;
		//stack<int> cycle;
		bool bCycle = false;

		void dfs(Digraph& G, int v)
		{
			onStack[v] = true;
			marked[v] = true;

			set<int> adj = G.adj(v);
			for (set<int> ::iterator itr = adj.begin(); itr != adj.end(); itr++)
			{
				if (hasCycle()) return;
				else if (!marked[*itr])
				{
					dfs(G, *itr);
				}
				else if (onStack[*itr])
				{
					bCycle = true;
				}
			}
			onStack[v] = false;
		}
	public:
		bool hasCycle()
		{
			return bCycle;
		}
		DirectedCycle(Digraph G)
		{
			onStack.resize(G.Vertices());
			edgeTo.resize(G.Vertices());
			marked.resize(G.Vertices());
			for(int i =0 ;i <G.Vertices();i++)
				if(!marked[i]) dfs(G, i);
		}
	};

	bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {

		Digraph graph(numCourses);
		for (int i = 0; i < prerequisites.size(); i++)
		{
			if(prerequisites[i][0]!= prerequisites[i][1])
				graph.addEdge(prerequisites[i][0], prerequisites[i][1]);
			/*for (int j = 0; j < prerequisites[i].size(); j++)
			{
				graph.addEdge(i, prerequisites[i][j]);
			}
			*/
		}
		DirectedCycle dc(graph);
		return !dc.hasCycle();
	}

};

