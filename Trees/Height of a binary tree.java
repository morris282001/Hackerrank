public static int height(Node root) {
      	
          if(root == null)
          {
              return -1;
          }
          int h1 = height(root.left);
          int h2 = height(root.right);
          int h3 = Math.max(h1,h2);
          return h3+1;
    }
